package com.example.tp3_parcial_belgrano_grupo4.data.network.services

import com.example.tp3_parcial_belgrano_grupo4.data.models.DogApiResponse
import com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces.DogsApi
import retrofit2.Call
import javax.inject.Inject

//Ejemplo por si deseas tomar en cuenta
//Clase Interactua con la api de perros
//Clase inyectable (Dagger Hilt)
class DogService @Inject constructor(
    private val api: DogsApi
) {

    fun listAllBreeds(): Call<DogApiResponse<Map<String, List<String>>>> {
        return api.listAllBreeds()
    }

    fun getRandomImage(): Call<DogApiResponse<String>> {
        return api.getRandomImage()
    }

    fun getImagesByBreed(breed: String, limit: Int): Call<DogApiResponse<List<String>>> {
        return api.getImagesByBreed(breed, limit)
    }

    fun getImagesBySubBreed(breed: String, subBreed: String, limit: Int): Call<DogApiResponse<List<String>>>
    {
        return api.getImagesBySubBreed(breed, subBreed, limit)
    }

    fun listAllSubBreeds(breed: String): Call<DogApiResponse<List<String>>> {
        return api.listAllSubBreeds(breed)
    }

    fun getRandomImageByBreed(breed: String): Call<DogApiResponse<String>> {
        return api.getRandomImageByBreed(breed)
    }
}

