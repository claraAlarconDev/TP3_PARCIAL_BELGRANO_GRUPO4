package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class RandomDogImageResponse(
    @SerializedName("message") val imageUrl: String,
    @SerializedName("status") val status: String
)

