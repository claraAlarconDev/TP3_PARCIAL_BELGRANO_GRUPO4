package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.domain.GetDogByIdUseCase
import com.example.tp3_parcial_belgrano_grupo4.domain.UpdateAdoptionStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateDogUseCase: UpdateAdoptionStatusUseCase,
    private val getDogByIdUseCase: GetDogByIdUseCase) : ViewModel() {

    private val _dog = MutableLiveData<DogModel>()
    val dog: LiveData<DogModel> = _dog

    fun setDog(dog: DogModel) {
        _dog.value = dog
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }


    suspend fun adoptDog(dog: DogEntity) {
        if (!dog.isAdopted) {
            updateDogUseCase.invoke(dog.idDog, true)
        }
    }

    suspend fun findDogById(idDog: Int): LiveData<DogEntity> {
        return getDogByIdUseCase.invoke(idDog)

    }
}

