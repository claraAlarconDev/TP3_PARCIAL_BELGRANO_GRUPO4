package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SubBreed_table")
data class SubBreedEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idSubBreed") val idSubBreed: Int = 0,
    @ColumnInfo(name = "idBreed") val idBreed: Int
)

