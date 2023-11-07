package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.domain.GetDogByIdUseCase
import com.example.tp3_parcial_belgrano_grupo4.domain.UpdateAdoptionStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(private val updateDogUseCase: UpdateAdoptionStatusUseCase, private val getDogByIdUseCase: GetDogByIdUseCase
) : ViewModel() {


    suspend fun adoptDog(dog: DogEntity) {
        if(!dog.isAdopted){
            updateDogUseCase.invoke(dog.idDog,true)
        }
    }

    suspend fun findDogById(idDog: Int): LiveData<DogEntity> {
        return getDogByIdUseCase.invoke(idDog)

    }

}