package com.example.pepe.ejemplobdroom.db.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.pepe.ejemplobdroom.constants.Constants;
import com.example.pepe.ejemplobdroom.db.dao.CursoDAO;
import com.example.pepe.ejemplobdroom.db.dao.ProfessorDAO;
import com.example.pepe.ejemplobdroom.db.entity.TCurso;
import com.example.pepe.ejemplobdroom.db.entity.TProfessor;

/*
* Clase que Funciona como BD, hay que extender de RoomDatabase, se le especifican las entidades
* El método "allowMainThreadQueries" permite hacer consultas en el hilo principal lo cual no es recomendable
* */

//Al introducir otra tabla la version se incrementa y se tiene que hacer una migracion para no perder los datos
@Database(entities = {TProfessor.class, TCurso.class}, version = 2)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCIA;

    public abstract ProfessorDAO professorDAO();
    public abstract CursoDAO cursoDAO();

    public static  AppDB getAppDB (Context context){
        if (INSTANCIA == null){
            INSTANCIA = Room.databaseBuilder(context.getApplicationContext(), AppDB.class,Constants.NAME_DATABASE)
                    .allowMainThreadQueries()
                    .addMigrations(MIGRACION_1_2) //Linea que permite la migracion
                    .build();
        }
        return INSTANCIA;
    }

    public static void destruirInstancia(){
        INSTANCIA = null;
    }

    //Migracion
    static final Migration MIGRACION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            /*database.execSQL("CREATE TABLE curso (id INTEGER PRIMARY KEY NOT NULL," +
                    "nombre TEXT, profesorId INTEGER NOT NULL," +
                    "FOREIGN KEY (professorID) references TProfessor(id) ON DELETE CASCADE)");*/

            database.execSQL("CREATE TABLE tcurso (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, duracion TEXT, professorId INTEGER NOT NULL, foreign key (professorId) references tprofessor(id) ON DELETE CASCADE)");
        }
    };
}


