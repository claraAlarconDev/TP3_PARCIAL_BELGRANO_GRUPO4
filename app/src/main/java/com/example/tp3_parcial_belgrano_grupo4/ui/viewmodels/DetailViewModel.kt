package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.domain.GetDogByIdUseCase
import com.example.tp3_parcial_belgrano_grupo4.domain.UpdateAdoptionStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateDogUseCase: UpdateAdoptionStatusUseCase,
    private val getDogByIdUseCase: GetDogByIdUseCase) : ViewModel() {

    private val _foundDog = MutableLiveData<DogEntity>()
    var foundDog: LiveData<DogEntity> = _foundDog

    // Function to fetch and set the found dog's information
    fun fetchDogById(idDog: Int): LiveData<DogEntity> {
        setIsLoading(true)
        val dogLiveData = MutableLiveData<DogEntity>()

        viewModelScope.launch {
            try {
                val dogEntity = getDogByIdUseCase.invoke(idDog)

                // Set the found dog's information in LiveData
                dogLiveData.postValue(dogEntity)

                // Perform any other necessary logic here

                setIsLoading(false)
            } catch (e: Exception) {
                // Handle any errors here
                setIsLoading(false)
            }
        }

        return dogLiveData
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

}

