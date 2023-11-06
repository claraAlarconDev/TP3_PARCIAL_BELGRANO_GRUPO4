package com.example.tp3_parcial_belgrano_grupo4.domain

import com.example.tp3_parcial_belgrano_grupo4.data.network.repositories.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import javax.inject.Inject

class InsertDogUseCase @Inject constructor(private val dogRepository: DogRepository) {
    suspend operator fun invoke(dog: Dog) {
        dogRepository.insertDog(dog)
    }
}