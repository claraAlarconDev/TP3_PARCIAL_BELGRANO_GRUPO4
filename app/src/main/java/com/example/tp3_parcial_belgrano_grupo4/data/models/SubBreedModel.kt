package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class SubBreedModel(
    @SerializedName("idSubBreed") val idSubBreed: Int,
    @SerializedName("idBreed") val idBreed: Int
)
