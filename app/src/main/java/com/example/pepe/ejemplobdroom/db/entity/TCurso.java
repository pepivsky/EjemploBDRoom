package com.example.pepe.ejemplobdroom.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.pepe.ejemplobdroom.constants.Constants;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Tabla TCurso con relación llave foranea (professorID) que es el "id" de la tabla TProfessor
 * Relación uno a muchos, un curso está dado por un profesor.
 */

@Entity(tableName = Constants.NAME_TABLE_CURSO,
            foreignKeys = @ForeignKey(entity = TProfessor.class,
            parentColumns = "id",
            childColumns = "professorId",
            onDelete = CASCADE))

public class TCurso {
//Llave primaria autogenerada
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "duracion") //Nombre de la columna: "duracion"
    public String duracion;

    @ColumnInfo(name = "professorId")
    public int professorId;

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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
