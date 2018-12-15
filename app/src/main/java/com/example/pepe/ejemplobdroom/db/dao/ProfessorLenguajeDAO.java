package com.example.pepe.ejemplobdroom.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pepe.ejemplobdroom.db.entity.TProfessor;
import com.example.pepe.ejemplobdroom.db.entity.TProfessorLenguaje;

import java.util.List;

@Dao
public interface ProfessorLenguajeDAO {

    @Insert
    void insert (TProfessorLenguaje tProfessorLenguaje);

    @Query("SELECT * FROM tprofessor INNER JOIN tprofessorlenguaje ON tprofessor.id = tprofessorlenguaje.professorId WHERE tprofessorlenguaje.lenguajeId=:lenguajeId")
    List<TProfessor> mostrarProfessoresxLenguaje(int lenguajeId);


    @Query("SELECT * FROM tlenguaje INNER JOIN tprofessorlenguaje ON tlenguaje.id = tprofessorlenguaje.lenguajeId WHERE tprofessorlenguaje.professorId=:professorId")
    List<TProfessor> mostrarLenguajesxProfesor(int professorId);
}

