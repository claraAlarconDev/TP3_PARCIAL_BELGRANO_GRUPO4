package com.example.tp3_parcial_belgrano_grupo4.data.models

data class OwnerModel(
    val id_Duenio: Int,
    val nombre: String,
    val imagen: String, //(String o ByteArray, por ejemplo)
    val telefono: String
)
