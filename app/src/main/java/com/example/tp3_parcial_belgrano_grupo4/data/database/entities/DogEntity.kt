package com.example.tp3_parcial_belgrano_grupo4.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog

@Entity(tableName = "Dog_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idDog") val idDog: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "breed") val breed: String,
    @ColumnInfo(name = "subBreed") val subBreed: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "observations") val observations: String,
    @ColumnInfo(name = "isAdopted") val isAdopted: Boolean,
    @ColumnInfo(name = "idOwner") val idOwner: Int,
    val location: String,
    val weight: String,
    val img: String
)

fun Dog.toDatabase() = DogEntity(
    name = name,
    age = age,
    breed = breed,
    subBreed = subBreed,
    gender = gender,
    description = description,
    observations = observations,
    isAdopted = isAdopted,
    idOwner = idOwner,
    location = location,
    weight = weight,
    img = img
)

fun DogEntity.toModel() = DogModel(
    idDog = idDog,
    name = name,
    age = age,
    breed = breed,
    subBreed = subBreed,
    gender = gender,
    description = description,
    observations = observations,
    isAdopted = isAdopted,
    idOwner = idOwner,
    location = location,
    weight = weight,
    img = img
)