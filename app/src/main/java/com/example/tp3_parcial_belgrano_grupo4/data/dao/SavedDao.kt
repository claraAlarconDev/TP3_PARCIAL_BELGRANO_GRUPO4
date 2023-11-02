package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface SavedDao {
    // OBTENER TODOS LOS REGISTROS DE GUARDADOS
    @Query("SELECT * FROM Guardados_table")
    suspend fun getAllGuardados(): List<GuardadosEntity>

    // INSERTAR TODOS LOS REGISTROS DE GUARDADOS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(guardados: List<GuardadosEntity>)
}