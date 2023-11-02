package com.example.tp3_parcial_belgrano_grupo4.data.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Owner_table")
data class OwnerEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idOwner") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "phone") val phone: String
)