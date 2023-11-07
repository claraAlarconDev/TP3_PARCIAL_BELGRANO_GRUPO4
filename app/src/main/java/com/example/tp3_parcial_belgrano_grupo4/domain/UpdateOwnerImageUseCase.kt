package com.example.tp3_parcial_belgrano_grupo4.domain

import com.example.tp3_parcial_belgrano_grupo4.data.repositories.OwnerRepository
import javax.inject.Inject

class UpdateOwnerImageUseCase @Inject constructor(private val repository: OwnerRepository) {


    suspend operator fun invoke(id: Int, imageUrl: String) : String{
        try {
            repository.updateImage(id, imageUrl)
            return "success"
        } catch(e: Exception){
            println("Caugth an exception: ${e.message}")
            return "Error: ${e.message}"
        }
    }
}