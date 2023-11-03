package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.BreedEntity

@Dao
interface BreedDao {
    // OBTENER TODAS LAS RAZAS
    @Query("SELECT * FROM Breed_table")
    suspend fun getAllBreeds(): List<BreedEntity>

    // INSERTAR TODAS LAS RAZAS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(breeds: List<BreedEntity>)

    @Query("DELETE FROM Breed_table")
    suspend fun deleteAllBreed()
}