package com.example.pepe.ejemplobdroom.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.pepe.ejemplobdroom.constants.Constants;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = Constants.NAME_TABLE_CURSO,
            foreignKeys = @ForeignKey(entity = TProfessor.class,
            parentColumns = "id",
            childColumns = "professorId",
            onDelete = CASCADE))

public class TCurso {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "duracion")
    public String duracion;

    @ColumnInfo(name = "professorId")
    public String professorId;

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

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }
}
