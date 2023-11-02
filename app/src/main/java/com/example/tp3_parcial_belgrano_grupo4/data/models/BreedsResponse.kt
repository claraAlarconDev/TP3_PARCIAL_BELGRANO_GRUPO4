package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class BreedsResponse(
    @SerializedName("message") val razas: Map<String, List<String>>,
    @SerializedName("status") val status: String
)
