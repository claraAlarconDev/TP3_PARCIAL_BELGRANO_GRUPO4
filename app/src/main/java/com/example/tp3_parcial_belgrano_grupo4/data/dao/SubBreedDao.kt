package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface SubBreedDao {
    // OBTENER TODAS LAS SUBRAZAS
    @Query("SELECT * FROM SubRaza_table")
    suspend fun getAllSubRazas(): List<SubRazaEntity>

    // INSERTAR TODAS LAS SUBRAZAS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(subRazas: List<SubRazaEntity>)
}