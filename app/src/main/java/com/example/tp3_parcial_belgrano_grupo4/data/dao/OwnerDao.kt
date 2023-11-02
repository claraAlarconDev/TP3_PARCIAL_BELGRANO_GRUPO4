package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface OwnerDao {
    // OBTENER TODOS LOS DUEÑOS
    @Query("SELECT * FROM Duenio_table")
    suspend fun getAllDuenios(): List<DuenioEntity>

    // INSERTAR TODOS LOS DUEÑOS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(duenios: List<DuenioEntity>)
}