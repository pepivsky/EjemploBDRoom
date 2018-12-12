package com.example.pepe.ejemplobdroom.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pepe.ejemplobdroom.db.entity.TCurso;

import java.util.List;

@Dao
public interface CursoDAO {

    @Insert
    void insert (TCurso tCurso);

    @Query("SELECT * FROM  tcurso WHERE professorId = :professorId")
    List<TCurso> buscarCursosPorProfessor(int professorId);

    @Update
    void updateCursoPorId(TCurso tCurso);

    @Delete
    void deleteCursoPorId(TCurso tCurso);
}
