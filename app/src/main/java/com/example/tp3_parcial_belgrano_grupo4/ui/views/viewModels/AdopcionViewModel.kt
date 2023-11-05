package com.example.tp3_parcial_belgrano_grupo4.ui.views.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogApiResponse
import com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces.DogService
import com.example.tp3_parcial_belgrano_grupo4.domain.InsertDogUseCase
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AdopcionViewModel @Inject constructor(
    private val dogService: DogService,
    private val insertDogUseCase: InsertDogUseCase,
    private val dogDao: DogDao // Aquí inyectas el DogDao
) : ViewModel() {

    private val _razas = MutableLiveData<List<String>>()
    val razas: LiveData<List<String>> get() = _razas

    private val _subrazas = MutableLiveData<List<String>>()
    val subrazas: LiveData<List<String>> get() = _subrazas

    private val _provincias = MutableLiveData<List<String>>()
    val provincias: LiveData<List<String>> get() = _provincias

    fun obtenerRazas() {
        dogService.listAllBreeds().enqueue(object : Callback<DogApiResponse<Map<String, List<String>>>> {
            override fun onResponse(
                call: Call<DogApiResponse<Map<String, List<String>>>>,
                response: Response<DogApiResponse<Map<String, List<String>>>>
            ) {
                if (response.isSuccessful) {
                    val razas = response.body()?.message?.keys?.toList() ?: emptyList()
                    _razas.postValue(razas)
                }
            }

            override fun onFailure(call: Call<DogApiResponse<Map<String, List<String>>>>, t: Throwable) {
                // Manejar fallo en la llamada (por ejemplo, mostrar un mensaje de error)
            }
        })
    }

    fun obtenerSubrazas(raza: String) {
        dogService.listAllSubBreeds(raza).enqueue(object : Callback<DogApiResponse<List<String>>> {
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

    fun cargarProvincias(context: Context) {
        val listaProvincias = context.resources.getStringArray(R.array.provincias).toList()
        _provincias.postValue(listaProvincias)
    }

    fun insertarNuevoPerro(dog: Dog) {
        viewModelScope.launch {
            insertDogUseCase(dog)
            // Verificar si el perro se insertó correctamente
            val allDogs = dogDao.getAllDogs()
            val perroInsertado = allDogs.find { it.name == dog.name && it.idOwner == dog.idOwner }

            if (perroInsertado != null) {
                // El perro se insertó correctamente
                Log.d("AdopcionViewModel", "El perro se insertó correctamente: $perroInsertado")
            } else {
                // Hubo un error al insertar el perro
                Log.e("AdopcionViewModel", "Error al insertar el perro")
            }
        }
    }
}
