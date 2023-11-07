package com.example.tp3_parcial_belgrano_grupo4.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.FavoriteEntity

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Favorite_table")
    fun getAllFavorites(): List<FavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(favorites: List<FavoriteEntity>)

    @Query("DELETE FROM Favorite_table")
    fun deleteAllFavorite()
}