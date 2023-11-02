package com.example.tp3_parcial_belgrano_grupo4.domain.model

import androidx.lifecycle.LifecycleOwner
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
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
    val idOwner:  Int,
    val idBreed:Int
)
    //FUNCION DE EXTENSION - DEVUELVE UN OBJETO DOG
    fun DogModel.toDomain()= Dog(idDog,name,age,sex,description,observations,adopted, idOwner ,idBreed)
    fun DogEntity.toDomain() = Dog(idDog,name,age,sex,description,observations,adopted, idOwner ,idBreed)
