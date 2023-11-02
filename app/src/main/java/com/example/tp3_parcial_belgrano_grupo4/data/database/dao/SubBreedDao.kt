package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SubBreedEntity

@Dao
interface SubBreedDao {
    @Query("SELECT * FROM SubBreed_table")
    suspend fun getAllSubBreeds(): List<SubBreedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(subBreeds: List<SubBreedEntity>)
}