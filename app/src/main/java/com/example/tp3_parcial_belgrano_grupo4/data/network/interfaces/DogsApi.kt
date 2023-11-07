package com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces

import com.example.tp3_parcial_belgrano_grupo4.data.models.DogApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {

    @GET("breeds/list/all")
    fun listAllBreeds(): Call<DogApiResponse<Map<String,List<String>>>>

    @GET("breeds/image/random")
    fun getRandomImage(): Call<DogApiResponse<String>>

    @GET("breed/{breed}/images")
    fun getImagesByBreed(@Path("breed") breed: String): Call<DogApiResponse<List<String>>>

    @GET("breed/{breed}/list")
    fun listAllSubBreeds(@Path("breed") breed: String): Call<DogApiResponse<List<String>>>

    @GET("breed/{breed}/images/random")
    fun getRandomImageByBreed(@Path("breed") breed: String): Call<DogApiResponse<String>>
}