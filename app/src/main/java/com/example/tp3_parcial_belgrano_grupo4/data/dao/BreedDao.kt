package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface BreedDao {
    // OBTENER TODAS LAS RAZAS
    @Query("SELECT * FROM Raza_table")
    suspend fun getAllRazas(): List<RazaEntity>

    // INSERTAR TODAS LAS RAZAS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(razas: List<RazaEntity>)
}