package com.example.tp3_parcial_belgrano_grupo4.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.toModel
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(private val dogRepository: DogRepository) : ViewModel() {

    private val _dogsList = MutableLiveData<List<DogModel>>()
    val dogsList: LiveData<List<DogModel>> = _dogsList

    fun setDogsList(dogsList: List<DogModel>) {
        _dogsList.value = dogsList
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun onCreate() {
        viewModelScope.launch {
            setIsLoading(true)
            try {
                val dogsList = dogRepository.getAllDogsWhereIsAdoptedFalse()
                Log.d("DogsViewModel", "Dogs list: $dogsList")
                setDogsList(dogsList.map { it.toModel() })
            } catch (e: Exception) {
                Log.e("DogsViewModel", "Error: ${e.message}")
            }
            setIsLoading(false)
        }
    }

    fun clear() {
        _dogsList.value = emptyList()
    }
}