package com.example.tp3_parcial_belgrano_grupo4.domain.model

import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel

//Ejemplo por si deseas tomar en cuenta

//MODELO DE DATO FINAL CON EL QUE TRABAJARA EL DOMINIO Y UI
data class Dog(
    val idDog: Int = 0,
    val name: String,
    val age: Int,
    val sex: String,
    val description: String,
    val observations: String,
    val adopted: Boolean,
    val idOwner: Int,
    val idBreed: Int,
    val location: String,
    val weight: String
)

//FUNCION DE EXTENSION - DEVUELVE UN OBJETO DOG
fun DogModel.toDomain() = Dog(
    idDog,
    name,
    age,
    sex,
    description,
    observations,
    adopted,
    idOwner,
    idBreed,
    location,
    weight
)

fun DogEntity.toDomain() = Dog(
    idDog,
    name,
    age,
    sex,
    description,
    observations,
    adopted,
    idOwner,
    idBreed,
    location,
    weight
)
