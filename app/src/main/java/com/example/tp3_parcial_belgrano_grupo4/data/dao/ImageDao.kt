package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface ImageDao {
    // OBTENER TODAS LAS IMÁGENES
    @Query("SELECT * FROM Imagen_table")
    suspend fun getAllImagenes(): List<ImagenEntity>

    // INSERTAR TODAS LAS IMÁGENES - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(imagenes: List<ImagenEntity>)
}