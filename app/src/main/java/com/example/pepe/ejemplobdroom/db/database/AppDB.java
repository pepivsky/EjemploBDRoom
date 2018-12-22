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
import com.example.pepe.ejemplobdroom.db.dao.LenguajeDAO;
import com.example.pepe.ejemplobdroom.db.dao.ProfessorDAO;
import com.example.pepe.ejemplobdroom.db.dao.ProfessorLenguajeDAO;
import com.example.pepe.ejemplobdroom.db.entity.TCurso;
import com.example.pepe.ejemplobdroom.db.entity.TLenguaje;
import com.example.pepe.ejemplobdroom.db.entity.TProfessor;
import com.example.pepe.ejemplobdroom.db.entity.TProfessorLenguaje;

/*
* Clase que Funciona como BD, hay que extender de RoomDatabase, se le especifican las entidades
* El método "allowMainThreadQueries" permite hacer consultas en el hilo principal lo cual no es recomendable
* */

//Al introducir otra tabla la version se incrementa y se tiene que hacer una migracion para no perder los datos
@Database(entities = {TProfessor.class, TCurso.class, TLenguaje.class, TProfessorLenguaje.class}, version = 4)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCIA;

    public abstract ProfessorDAO professorDAO();
    public abstract CursoDAO cursoDAO();
    public abstract LenguajeDAO lenguajeDAO();
    public abstract ProfessorLenguajeDAO professorLenguajeDAO();

    public static  AppDB getAppDB (Context context){
        if (INSTANCIA == null){
            INSTANCIA = Room.databaseBuilder(context.getApplicationContext(), AppDB.class,Constants.NAME_DATABASE)
                    .allowMainThreadQueries()
                    .addMigrations(MIGRACION_1_2) //Linea que permite la migracion
                    .addMigrations(MIGRACION_2_3) //Segunda migracion
                    .addMigrations(MIGRACION_3_4) //Tercera migración
                    .build();
        }
        return INSTANCIA;
    }

    public static void destruirInstancia(){
        INSTANCIA = null;
    }

    //Migracion para crear la tabla curso y la relacion de esta con la tabla professor
    static final Migration MIGRACION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE tcurso (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, duracion TEXT, professorId INTEGER NOT NULL, foreign key (professorId) references tprofessor(id) ON DELETE CASCADE)");
        }
    };


    //Segunda Migracion para crear la tabla lenguaje
    static final Migration MIGRACION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE tlenguaje (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT)");
        }
    };


    //tercera Migracion para crear la tabla de relacion de muchos a muchos "TProfessorLenguaje" para unir las tablas professor y lenguaje
    //Un profesor puede enseñar muchos lenguajes de programacion y muchos lenguajes de programación pueden ser enseñados por muchos profesores

    static final Migration MIGRACION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //database.execSQL("CREATE TABLE tprofessorlenguaje (professorId INTEGER NOT NULL, lenguajeId INTEGER NOT NULL, PRIMARY KEY(professorId, lenguajeId) foreign key(professorId) references tprofessor(id),foreign key(lenguajeId) references tlenguaje(id))");

            database.execSQL("CREATE TABLE tprofessorlenguaje (professorId INTEGER NOT NULL, lenguajeId INTEGER NOT NULL, PRIMARY KEY (professorId, lenguajeId),  foreign key (professorId) references tprofessor(id), foreign key (lenguajeId) references tlenguaje(id))");
        }
    };
}


