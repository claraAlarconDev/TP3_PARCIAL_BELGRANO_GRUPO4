package com.example.tp3_parcial_belgrano_grupo4.data.repositories

import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import javax.inject.Inject

class DogRepository  @Inject constructor(
    private val dogDao: DogDao
){
    suspend fun insertDogs(dogs: List<DogEntity>){
        dogDao.insertAll(dogs)
    }

    suspend fun clearDogs(){
        dogDao.deleteAllDogs()
    }
    suspend fun updateDogAdoptionStatus(dogId: Int, isAdopted: Boolean) {
        dogDao.updateAdoptionStatus(dogId, isAdopted)
    }

    suspend fun insertOneDog(dog:DogEntity){
        dogDao.insertOne(dog)
    }



}