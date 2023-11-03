package com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces

import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Ejemplo por si deseas tomar en cuenta
//Clase Interactua con la api de perros
//Clase inyectable (Dagger Hilt)
class DogService @Inject constructor(private val api:DogsApi){

}

