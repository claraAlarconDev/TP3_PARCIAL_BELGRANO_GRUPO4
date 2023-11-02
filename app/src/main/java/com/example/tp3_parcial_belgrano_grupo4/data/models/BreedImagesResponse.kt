package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class BreedImagesResponse(
    @SerializedName("message") val imageUrls: List<String>,
    @SerializedName("status") val status: String
)
