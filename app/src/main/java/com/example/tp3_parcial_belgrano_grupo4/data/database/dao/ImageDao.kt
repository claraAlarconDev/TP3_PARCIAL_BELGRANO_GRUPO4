package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.ImageEntity

@Dao
interface ImageDao {
    @Query("SELECT * FROM Image_Table")
    fun getAllImages(): List<ImageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(images: List<ImageEntity>)

    @Query("DELETE FROM Image_table")
    fun deleteAllImages()
}