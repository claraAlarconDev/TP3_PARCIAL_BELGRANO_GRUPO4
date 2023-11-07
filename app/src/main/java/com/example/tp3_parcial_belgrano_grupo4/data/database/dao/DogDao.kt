package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity

@Dao
interface DogDao {
    @Query("SELECT * FROM Dog_table")
    suspend fun getAllDogs(): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dogs: List<DogEntity>)

    @Query("DELETE FROM Dog_table")
    suspend fun deleteAllDogs()

    @Query("SELECT * FROM Dog_table WHERE isAdopted == 0")
    suspend fun getAllDogsWhereIsAdoptedFalse(): List<DogEntity>
}