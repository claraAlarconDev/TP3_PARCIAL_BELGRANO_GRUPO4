package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface DogDao {
    //OBTENER TODOS LOS CAMPOS
    @Query ("SELECT * FROM Dog_table")
    suspend fun getAllDogs(): List<DogEntity>

    //INSERTAR TODOS LOS CAMPOS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dogs: List<DogEntity>)