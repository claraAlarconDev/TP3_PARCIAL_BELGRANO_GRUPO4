package com.example.tp3_parcial_belgrano_grupo4.domain

import com.example.tp3_parcial_belgrano_grupo4.data.repositories.OwnerRepository
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Owner
import javax.inject.Inject

class GetOwnersUseCase @Inject constructor(private val repository: OwnerRepository) {

    suspend operator fun invoke() : List<Owner> {
        val response: List<Owner> = repository.getAllOwners();
        return response
    }



}