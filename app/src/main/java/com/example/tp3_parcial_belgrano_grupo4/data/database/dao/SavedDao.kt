package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SavedEntity

@Dao
interface SavedDao {
    @Query("SELECT * FROM Saved_table")
    suspend fun getAllSaved(): List<SavedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(saved: List<SavedEntity>)

    @Query("DELETE FROM Saved_table")
    suspend fun deleteAllSaved()
}