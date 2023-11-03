package com.example.tp3_parcial_belgrano_grupo4.data.models

import com.google.gson.annotations.SerializedName

data class FavoriteModel(
    @SerializedName("idFavorite") val idFavorite:Int,
    @SerializedName("idOwner") val idOwner: Int,
    @SerializedName("idDog") val idDog: Int
)
