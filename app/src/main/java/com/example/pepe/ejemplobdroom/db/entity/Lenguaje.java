package com.example.pepe.ejemplobdroom.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.pepe.ejemplobdroom.constants.Constants;

/**
 * Entidad Lenguaje que hace alusión a los lenguajes de programación
 */

@Entity(tableName = Constants.NAME_TABLE_LENGUAJE)
public class Lenguaje {

    //Id
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public int id;

    //Nombre
    @ColumnInfo(name = "nombre")
    public String nombre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
