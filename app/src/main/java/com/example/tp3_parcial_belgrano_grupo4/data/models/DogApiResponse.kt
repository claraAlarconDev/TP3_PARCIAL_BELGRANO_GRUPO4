package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class DogApiResponse<T> (
    @SerializedName("message") val message: T,
    @SerializedName("status") val images: String
)