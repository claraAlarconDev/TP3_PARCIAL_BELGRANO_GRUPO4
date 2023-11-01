package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class DogsResponse(
    @SerializedName("message") var images: List<String>,
    @SerializedName("status") var status: String
)
