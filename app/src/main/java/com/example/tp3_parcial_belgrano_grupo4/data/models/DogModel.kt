package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("idDog") val idDog: Int = 0,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int,
    @SerializedName("breed") val breed: String,
    @SerializedName("subBreed") val subBreed: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("description") val description: String,
    @SerializedName("observations") val observations: String,
    @SerializedName("isAdopted") val isAdopted: Boolean,
    @SerializedName("idOwner") val idOwner: Int,
    val location: String,
    val weight: String,
    val img: String
)
