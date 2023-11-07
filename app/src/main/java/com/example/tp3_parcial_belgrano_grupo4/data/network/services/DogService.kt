package com.example.tp3_parcial_belgrano_grupo4.data.network.services

import com.example.tp3_parcial_belgrano_grupo4.data.models.DogApiResponse
import com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces.DogsApi
import retrofit2.Call
import javax.inject.Inject

class DogService @Inject constructor(
    private val api: DogsApi
) {

    fun listAllBreeds(): Call<DogApiResponse<Map<String, List<String>>>> {
        return api.listAllBreeds()
    }

    fun getRandomImage(): Call<DogApiResponse<String>> {
        return api.getRandomImage()
    }

    fun getImagesByBreed(breed: String): Call<DogApiResponse<List<String>>> {
        return api.getImagesByBreed(breed)
    }

    fun listAllSubBreeds(breed: String): Call<DogApiResponse<List<String>>> {
        return api.listAllSubBreeds(breed)
    }

    fun getRandomImageByBreed(breed: String): Call<DogApiResponse<String>> {
        return api.getRandomImageByBreed(breed)
    }
}

