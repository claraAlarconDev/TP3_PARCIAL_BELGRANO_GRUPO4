package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog

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
    @ColumnInfo(name = "adopted") val adopted: Boolean,
    @ColumnInfo(name = "idOwner") val idOwner: Int,
    @ColumnInfo(name = "breed") val breed: String,
    @ColumnInfo(name = "subBreed") val subBreed: String?,
    val location: String,
    val weight: String,
    val photos: String
)

//Ejemplo por si deseas tomar en cuenta
//Funcion de extension para Database
fun Dog.toDatabase() = DogEntity(
    name = name,
    age = age,
    sex = sex,
    description = description,
    observations = observations,
    adopted = adopted,
    idOwner = idOwner,
    breed = breed,
    subBreed = subBreed,
    location = location,
    weight = weight,
    photos = photos
)