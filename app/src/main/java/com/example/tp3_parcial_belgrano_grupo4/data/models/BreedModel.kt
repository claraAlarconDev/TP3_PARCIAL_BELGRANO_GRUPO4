package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class BreedModel(
    @SerializedName("idBreed") val idBreed: Int,
    @SerializedName("idDog") val idDog: Int
)
