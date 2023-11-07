package com.example.tp3_parcial_belgrano_grupo4.domain

import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import javax.inject.Inject

class UpdateAdoptionStatusUseCase @Inject constructor(private val repository: DogRepository) {
    suspend fun invoke(dogId: Int, isAdopted: Boolean) {
        repository.updateDogAdoptionStatus(dogId, isAdopted)
    }
}
