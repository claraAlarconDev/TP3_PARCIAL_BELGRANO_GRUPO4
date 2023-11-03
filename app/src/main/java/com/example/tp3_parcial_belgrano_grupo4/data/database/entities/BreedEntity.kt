package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Breed_table")
data class BreedEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idBreed") val idBreed: Int = 0,
    @ColumnInfo(name = "idDog") val idDog: Int
)