package com.example.tp3_parcial_belgrano_grupo4.data.models

data class DogModel(
    val id_Perro: Int,
    val nombre: String,
    val edad: Int,
    val sexo: String,
    val descripcion: String,
    val observaciones: String,
    val adoptado: Boolean,
    val id_Duenio: Int,
    val id_Raza: Int
)
