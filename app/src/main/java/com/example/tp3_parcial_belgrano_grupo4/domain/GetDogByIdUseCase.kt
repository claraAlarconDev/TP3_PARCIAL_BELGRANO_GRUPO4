package com.example.tp3_parcial_belgrano_grupo4.domain

import androidx.lifecycle.LiveData
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import javax.inject.Inject

class GetDogByIdUseCase @Inject constructor(private val repository: DogRepository)  {
    suspend operator fun invoke(idDog: Int): DogEntity {
        return repository.getDogById(idDog)
    }
}