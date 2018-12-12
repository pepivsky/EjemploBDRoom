package com.example.pepe.ejemplobdroom.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pepe.ejemplobdroom.db.entity.TLenguaje;

import java.util.List;

/**
 * DAO para la entidad TLenguaje
 */

@Dao
public interface LenguajeDAO {

    //Query para insertar un lenguaje, recibe un lenguaje como parámetro
    @Insert
    void insert(TLenguaje TLenguaje);

    //Query para mostrar todos los lenguajes de la tabla tlenguaje
    @Query("SELECT * FROM tlenguaje")
    List<TLenguaje> mostrarLenguajes();

    @Update
    void actualizarLenguajePorId(TLenguaje tLenguaje);

    @Delete
    void borrarLenguajePorId(TLenguaje tLenguaje);
}
