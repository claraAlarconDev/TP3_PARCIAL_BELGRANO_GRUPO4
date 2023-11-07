package com.example.tp3_parcial_belgrano_grupo4.domain


import com.example.tp3_parcial_belgrano_grupo4.data.repositories.OwnerRepository
import javax.inject.Inject

class GetOwnerAttributeUseCase @Inject constructor(private val repository: OwnerRepository) {


    suspend operator fun invoke(id: Int, att: String): String {
        try {
            return repository.getOwnerAttribute(id, att)
        } catch (err: Exception) {
            throw Exception("No se puede obtener el atributo que desea")
        }
    }
}