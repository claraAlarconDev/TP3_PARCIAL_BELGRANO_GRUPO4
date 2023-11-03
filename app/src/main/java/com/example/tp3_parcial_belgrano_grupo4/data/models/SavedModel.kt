package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class SavedModel(
    @SerializedName("idSaved") val idSaved:Int,
    @SerializedName("idFavorite") val idFavorite: Int,
    @SerializedName("idOwner") val idOwner:Int
)