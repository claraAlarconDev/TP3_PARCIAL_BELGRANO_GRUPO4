package com.example.tp3_parcial_belgrano_grupo4.domain.model

import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel

data class Dog(
    val idDog: Int = 0,
    val name: String,
    val age: Int,
    val breed: String,
    val subBreed: String,
    val gender: String,
    val description: String,
    val observations: String,
    val isAdopted: Boolean,
    val idOwner: Int,
    val location: String,
    val weight: String,
    val img: String
)

fun DogEntity.toDatabase() = Dog(
    idDog,
    name,
    age,
    breed,
    subBreed,
    gender,
    description,
    observations,
    isAdopted,
    idOwner,
    location,
    weight,
    img
)

fun DogEntity.toDomain() = Dog(
    idDog,
    name,
    age,
    breed,
    subBreed,
    gender,
    description,
    observations,
    isAdopted,
    idOwner,
    location,
    weight,
    img
)
