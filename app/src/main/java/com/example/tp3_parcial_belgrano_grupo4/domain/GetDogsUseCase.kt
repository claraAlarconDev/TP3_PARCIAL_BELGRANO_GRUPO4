package com.example.tp3_parcial_belgrano_grupo4.domain

import com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(private val repository: DogRepository) {

}