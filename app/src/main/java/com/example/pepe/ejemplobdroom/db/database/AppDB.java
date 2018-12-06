package com.example.pepe.ejemplobdroom.db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pepe.ejemplobdroom.constants.Constants;
import com.example.pepe.ejemplobdroom.db.dao.ProfessorDAO;
import com.example.pepe.ejemplobdroom.db.entity.TProfessor;

/*
* Clase que Funciona como BD, hay que extender de RoomDatabase, se le especifican las entidades
* El método "allowMainThreadQueries" permite hacer consultas en el hilo principal lo cual no es recomendable
* */

@Database(entities = {TProfessor.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCIA;

    public abstract ProfessorDAO professorDAO();

    public static  AppDB getAppDB (Context context){
        if (INSTANCIA == null){
            INSTANCIA = Room.databaseBuilder(context.getApplicationContext(), AppDB.class,Constants.NAME_DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCIA;
    }

    public static void destruirInstancia(){
        INSTANCIA = null;
    }
}


