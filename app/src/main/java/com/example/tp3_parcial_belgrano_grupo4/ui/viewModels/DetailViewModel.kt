package com.example.tp3_parcial_belgrano_grupo4.ui.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.domain.GetDogByIdUseCase
import com.example.tp3_parcial_belgrano_grupo4.domain.UpdateAdoptionStatusUseCase
import com.example.tp3_parcial_belgrano_grupo4.ui.fragments.AdopcionFragment_MembersInjector
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateDogUseCase: UpdateAdoptionStatusUseCase,
    private val getDogByIdUseCase: GetDogByIdUseCase,
    private val dogRepository: DogRepository
) : ViewModel() {

    private val _dog = MutableLiveData<DogEntity>()
    val dog: LiveData<DogEntity> = _dog


    // Function to fetch and set the found dog's information
    /**suspend fun fetchDogById(idDog: Int): LiveData<DogEntity> {
        withContext(Dispatchers.IO){
            setIsLoading(true)
            val dogLiveData = MutableLiveData<DogEntity>()

            viewModelScope.launch {
                try {
                    val dogEntity = getDogByIdUseCase.invoke(idDog)

                    // Set the found dog's information in LiveData
                    dogLiveData.postValue(dogEntity)
                    return dogLiveData
                    // Perform any other necessary logic here

                    setIsLoading(false)
                } catch (e: Exception) {
                    // Handle any errors here
                    setIsLoading(false)
                }
            }


        }

    }**/


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun setDog(dog: DogEntity) {
        _dog.value = dog
    }

    fun onCreate(dogId: Int){
        viewModelScope.launch {
            setIsLoading(true)
            try {
                val dog = dogRepository.getDogById(dogId)

            }catch (e: Exception){

            }
        }
    }
    suspend fun getDogById(dogId:Int){ withContext(Dispatchers.IO) {
            getDogByIdUseCase.invoke(dogId)
        }
    }

    suspend fun adoptDog(dog: DogEntity) {withContext(Dispatchers.IO) {
            if (!dog.isAdopted) {
                updateDogUseCase.invoke(dog.idDog, true)
            }
        }
    }

}

