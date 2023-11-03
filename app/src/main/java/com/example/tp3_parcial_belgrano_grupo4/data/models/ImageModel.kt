package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("idImage") val idImage:Int,
    @SerializedName("idDog") val idDog:Int,
    @SerializedName("urlImage") val urlImage: String
)
