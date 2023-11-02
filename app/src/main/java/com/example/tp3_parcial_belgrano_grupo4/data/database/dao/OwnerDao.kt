package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.OwnerEntity

@Dao
interface OwnerDao {
    @Query("SELECT * FROM Owner_table")
    suspend fun getAllOwners(): List<OwnerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(owners: List<OwnerEntity>)
}