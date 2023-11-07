package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Image_Table")
data class ImageEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idImage") val idImage: Int = 0,
    @ColumnInfo(name = "idDog") val idDog: Int,
    @ColumnInfo(name = "urlImage") val urlImage:String
)
