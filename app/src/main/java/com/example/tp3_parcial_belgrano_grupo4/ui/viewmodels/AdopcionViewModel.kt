package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogApiResponse
import com.example.tp3_parcial_belgrano_grupo4.data.network.services.DogService
import com.example.tp3_parcial_belgrano_grupo4.domain.InsertDogUseCase
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AdopcionViewModel @Inject constructor(
    private val dogService: DogService,
    private val insertDogUseCase: InsertDogUseCase,
    private val dogDao: DogDao
) : ViewModel() {

    private val _razas = MutableLiveData<List<String>>()
    val razas: LiveData<List<String>> get() = _razas

    private val _subrazas = MutableLiveData<List<String>>()
    val subrazas: LiveData<List<String>> get() = _subrazas

    private val _provincias = MutableLiveData<List<String>>()
    val provincias: LiveData<List<String>> get() = _provincias

    suspend fun obtenerRazas() {
        withContext(Dispatchers.IO) {
            dogService.listAllBreeds()
                .enqueue(object : Callback<DogApiResponse<Map<String, List<String>>>> {
                    override fun onResponse(
                        call: Call<DogApiResponse<Map<String, List<String>>>>,
                        response: Response<DogApiResponse<Map<String, List<String>>>>
                    ) {
                        if (response.isSuccessful) {
                            val razas = response.body()?.message?.keys?.toList() ?: emptyList()
                            _razas.postValue(razas)
                        }
                    }

                    override fun onFailure(
                        call: Call<DogApiResponse<Map<String, List<String>>>>,
                        t: Throwable
                    ) {
                        // Manejar fallo en la llamada (por ejemplo, mostrar un mensaje de error)
                    }
                })
        }
    }

   suspend fun obtenerSubrazas(raza: String) {
       withContext(Dispatchers.IO) {
           dogService.listAllSubBreeds(raza)
               .enqueue(object : Callback<DogApiResponse<List<String>>> {
                   override fun onResponse(
                       call: Call<DogApiResponse<List<String>>>,
                       response: Response<DogApiResponse<List<String>>>
                   ) {
                       if (response.isSuccessful) {
                           val subrazas = response.body()?.message ?: emptyList()
                           _subrazas.postValue(subrazas)
                       }
                   }

                   override fun onFailure(call: Call<DogApiResponse<List<String>>>, t: Throwable) {
                       // Manejar fallo en la llamada (por ejemplo, mostrar un mensaje de error)
                   }
               })
       }
    }

     fun cargarProvincias(context: Context) {
            val listaProvincias = context.resources.getStringArray(R.array.provincias).toList()
            _provincias.postValue(listaProvincias)
    }

    suspend fun insertarNuevoPerro(
        nombre: String,
        edad: Int,
        gender: String,
        descripcion: String,
        observaciones: String,
        idOwner: Int,
        raza: String,
        subraza: String,
        ubicacion: String,
        peso: String,
        fotos: String // Nuevas fotos como lista de Strings
    ) {
        withContext(Dispatchers.IO) {
            val dog = Dog(
                name = nombre,
                age = edad,
                gender = gender,
                description = descripcion,
                observations = observaciones,
                isAdopted = false,
                idOwner = idOwner,
                breed = raza,
                subBreed = subraza,
                location = ubicacion,
                weight = peso,
                img = fotos
            )
            insertDogUseCase(dog)
            val allDogs = dogDao.getAllDogs()
            val perroInsertado = allDogs.find { it.name == nombre && it.idOwner == idOwner }

            if (perroInsertado != null) {
                Log.d("AdopcionViewModel", "El perro se insertó correctamente: $perroInsertado")
            } else {
                Log.e("AdopcionViewModel", "Error al insertar el perro")
            }
        }
    }


    suspend fun tieneSubrazas(raza: String): Boolean {
        return withContext(Dispatchers.IO) {
            subrazas.value?.isNotEmpty() ?: false
        }
    }
}
