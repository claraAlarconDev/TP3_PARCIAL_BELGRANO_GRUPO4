package com.example.tp3_parcial_belgrano_grupo4.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_parcial_belgrano_grupo4.data.entities.RazaEntity

@Dao
interface FavoriteDao {
    // OBTENER TODOS LOS FAVORITOS
    @Query("SELECT * FROM Favoritos_table")
    suspend fun getAllFavoritos(): List<FavoritosEntity>

    // INSERTAR TODOS LOS FAVORITOS - EN CASO DE EXISTIR UN CONFLICTO LO REEMPLAZA
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(favoritos: List<FavoritosEntity>)
}