package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Saved_table")
data class SavedEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idSaved") val idSaved: Int = 0,
    @ColumnInfo(name = "idFavorite") val idFavorite: Int,
    @ColumnInfo(name = "idOwner") val idOwner: String
)