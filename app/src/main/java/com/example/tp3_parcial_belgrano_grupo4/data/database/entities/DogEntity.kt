package com.example.tp3_parcial_belgrano_grupo4.data.database.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dog_table") //Nombre de la tabla en base
data class DogEntity(
    // name (Nombre con el cual se guarda en la base) - PK se Autogenera
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idDog") val idDog: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "sex") val sex: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "observations") val observations: String,
    @ColumnInfo(name = "idDuenio") val idDuenio: String,
    @ColumnInfo(name = "idRaza") val idRaza: String
)