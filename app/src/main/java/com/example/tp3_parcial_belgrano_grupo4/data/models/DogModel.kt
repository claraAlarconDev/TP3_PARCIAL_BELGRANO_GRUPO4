package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("idDog") val idDog: Int,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int,
    @SerializedName("sex") val sex: String,
    @SerializedName("description") val description: String,
    @SerializedName("observations") val observations: String,
    @SerializedName("adopted") val adopted: Boolean,
    @SerializedName("idOwner") val idOwner: Int,
    @SerializedName("idBreed") val idBreed: Int,
    val location: String,
    val weight: String
)
