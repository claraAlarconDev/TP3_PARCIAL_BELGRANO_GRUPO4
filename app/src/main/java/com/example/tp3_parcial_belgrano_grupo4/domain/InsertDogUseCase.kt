package com.example.tp3_parcial_belgrano_grupo4.domain

import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertDogUseCase @Inject constructor(private val dogRepository: DogRepository) {
    suspend operator fun invoke(dog: Dog) {
        withContext(Dispatchers.IO) {
            dogRepository.insertDog(dog)
        }
    }
}