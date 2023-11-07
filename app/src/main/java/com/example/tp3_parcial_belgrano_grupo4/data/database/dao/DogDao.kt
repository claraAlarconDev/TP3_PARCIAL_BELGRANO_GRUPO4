package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.lifecycle.LiveData
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

    @Query("SELECT * FROM Dog_table WHERE isAdopted == 1")
    suspend fun getAllDogsWhereIsAdoptedTrue(): List<DogEntity>

    @Query("SELECT * FROM Dog_table WHERE idDog = :dogId")
    fun getDogById(dogId: Int): LiveData<DogEntity>

    @Query("UPDATE Dog_table SET isAdopted = :adopted WHERE idDog = :dogId")
    suspend fun updateAdoptionStatus(dogId: Int, adopted: Boolean)
}