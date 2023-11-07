package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels


import androidx.lifecycle.ViewModel
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.domain.UpdateAdoptionStatusUseCase
import javax.inject.Inject


class DogViewModel @Inject constructor(
    private val updateDogUseCase: UpdateAdoptionStatusUseCase
) : ViewModel() {

    /**private val _dogAdopted = MutableLiveData<Boolean>()
    val dogAdopted: LiveData<Boolean>
        get() = _dogAdopted**/

    suspend fun adoptDog(dog: DogEntity) {
        if(!dog.adopted){
            updateDogUseCase.invoke(dog.idDog,true)
        }
    }

}