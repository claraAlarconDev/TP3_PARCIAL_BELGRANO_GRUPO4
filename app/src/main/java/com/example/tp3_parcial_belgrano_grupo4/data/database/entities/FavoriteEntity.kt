package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite_table")
data class FavoriteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idFavorite") val idFavorite: Int = 0,
    @ColumnInfo( name = "idOwner") val idOwner: Int,
    @ColumnInfo( name = "IdDog") val idDog: Int
)
