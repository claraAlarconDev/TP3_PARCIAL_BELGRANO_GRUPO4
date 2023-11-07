package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SubBreedEntity

@Dao
interface SubBreedDao {
    @Query("SELECT * FROM SubBreed_table")
    fun getAllSubBreeds(): List<SubBreedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(subBreeds: List<SubBreedEntity>)

    @Query("DELETE FROM SubBreed_table")
    fun deleteAllSubBreed()
}