package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

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

    @Query("DELETE FROM Owner_table")
    suspend fun deleteAllOwners()

    @Query("SELECT * FROM Owner_table WHERE idOwner = :id ")
    suspend fun getOwnerById(id: Int): OwnerEntity

    @Query("SELECT name, image FROM Owner_table WHERE idOwner = :id")
    suspend fun getImageAndName(id: Int) : OwnerImageName

    @Query("SELECT :att FROM Owner_table WHERE idOwner = :id")
    suspend fun getOwnerAttribute(id: Int, att: String): String

    @Query("UPDATE Owner_table SET image = :imageUrl WHERE idOwner = :id")
    suspend fun updateImage(id: Int, imageUrl: String)
}

data class OwnerImageName(val name: String?, val image: String?)