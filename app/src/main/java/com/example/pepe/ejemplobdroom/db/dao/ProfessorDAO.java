package com.example.pepe.ejemplobdroom.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pepe.ejemplobdroom.db.entity.TProfessor;

import java.util.List;
@Dao
public interface ProfessorDAO {

    @Insert
    void insertProfessor( TProfessor tprofessor);

    //Consulta para ver todos los profesores que hay en la BD
    @Query("SELECT * FROM tprofessor")
    List<TProfessor> findAllProfessor();

    //Consulta para buscar un profesor por su nombre
    @Query("SELECT * FROM tprofessor WHERE nombre LIKE :nombre")
    TProfessor findProfessorbyName (String nombre);

    //Consulta para buscar un profesor por su id
    @Query("SELECT * FROM tprofessor WHERE id LIKE :id")
    TProfessor findProfessorbyID (int id);

    //Actualizar los datos de un profesor
    @Update
    void updateProfessorById(TProfessor tProfessor);

    //Borrar todos los profesores de la BD
    @Query("DELETE FROM tprofessor")
    void deleteAllProfessor();

    //Borrar un profesor por su id
    @Delete
    void deleteProfessorbyID(TProfessor tProfessor);
}
