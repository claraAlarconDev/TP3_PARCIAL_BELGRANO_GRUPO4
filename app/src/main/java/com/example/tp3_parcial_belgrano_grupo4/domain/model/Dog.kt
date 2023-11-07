package com.example.tp3_parcial_belgrano_grupo4.domain.model

import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel


data class Dog(
    val idDog: Int = 0,
    val name: String,
    val age: Int,
    val gender: String,
    val description: String,
    val observations: String,
    val isAdopted: Boolean,
    val idOwner: Int,
    val breed: String,
    val subBreed: String?,
    val location: String,
    val weight: String,
    val photos: String
)


fun DogEntity.toDomain(): Dog {
    return Dog(
        idDog,
        name,
        age,
        gender,
        description,
        observations,
        isAdopted,
        idOwner,
        breed,
        subBreed,
        location,
        weight,
        photos
    )
}
fun DogModel.toDomain() = Dog(
    idDog,
    name,
    age,
    gender,
    description,
    observations,
    isAdopted,
    idOwner,
    breed,
    subBreed,
    location,
    weight,
    photos
)

