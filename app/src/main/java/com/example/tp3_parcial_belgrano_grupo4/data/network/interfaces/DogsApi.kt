package com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces

import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import retrofit2.Response
import retrofit2.http.GET

interface DogsApi {
    //Ejemplo por si deseas tomar en cuenta - la ruta era para que no lanzara el error
    @GET ("/ .json")
    suspend fun getAllDogs(): Response<List<DogModel>>
}

