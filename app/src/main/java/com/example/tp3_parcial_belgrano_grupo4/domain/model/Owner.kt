package com.example.tp3_parcial_belgrano_grupo4.domain.model

import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.OwnerEntity

data class Owner(
    val name: String?,
    val image: String?,
    val phone: String?
)


fun OwnerEntity.toDomain() = Owner( name, image, phone)

