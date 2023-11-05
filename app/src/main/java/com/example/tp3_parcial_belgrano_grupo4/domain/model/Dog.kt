package com.example.tp3_parcial_belgrano_grupo4.domain.model

import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity


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
    val breed: String,
    val subBreed: String,
    val location: String,
    val weight: String
)


fun DogEntity.toDomain(): Dog {
    return Dog(
        idDog,
        name,
        age,
        sex,
        description,
        observations,
        adopted,
        idOwner,
        breed,
        subBreed,
        location,
        weight
    )
}
