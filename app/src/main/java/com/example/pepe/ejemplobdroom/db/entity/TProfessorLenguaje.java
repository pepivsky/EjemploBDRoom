package com.example.pepe.ejemplobdroom.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import com.example.pepe.ejemplobdroom.constants.Constants;

/**
 * Entidad ProfesorLenguaje es una tabla intermedia entre professor y lenguaje para hacer la
 * relación de muchos a muchos
 * Un profesor puede enseñar muchos lenguajes de programacion y muchos lenguajes de programación pueden ser enseñados por muchos profesores
 */

@Entity(tableName = Constants.NAME_TABLE_PROFESSORLENGUAJE,
primaryKeys = {"professorId", "lenguajeId"},
foreignKeys =
@ForeignKey(entity = TProfessor.class, parentColumns = "id", childColumns = "professorId"))
@ForeignKey(entity = TLenguaje.class, parentColumns = "id", childColumns = "lenguajeId")

public class TProfessorLenguaje {

    @ColumnInfo(name = "professorId")
    public int professorId;

    @ColumnInfo(name = "lenguajeId")
    public int lenguajeId;

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getLenguajeId() {
        return lenguajeId;
    }

    public void setLenguajeId(int lenguajeId) {
        this.lenguajeId = lenguajeId;
    }
}
