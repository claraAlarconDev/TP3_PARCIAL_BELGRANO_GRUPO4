package com.example.tp3_parcial_belgrano_grupo4.data.repositories

import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.toDatabase
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogDao: DogDao
) {
    suspend fun insertDogs(dogs: List<DogEntity>) {
        val dog1 = DogEntity(
            1,
            "Milu",
            4,
            "hembra",
            "Tierna",
            "Juguetona",
            true,
            5,
            "cattledog",
            "australian",
            "Buenos Aires",
            "5kg",
            "https://images.dog.ceo/breeds/cattledog-australian/IMG_9350.jpg"
        )

        val dog2 = DogEntity(
            2,
            "Cachirulo",
            4,
            "macho",
            "vagoneta",
            "callejero",
            false,
            5,
            "australian",
            "",
            "Merlo",
            "7kg",
            "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"
        )

        val dog3 = DogEntity(
            3,
            "Rayo",
            4,
            "hembra",
            "",
            "beagle",
            false,
            1,
            "beagle",
            "",
            "Mendoza",
            "5kg",
            "https://images.dog.ceo/breeds/papillon/n02086910_4999.jpg"
        )

        val dog4 = DogEntity(
            4,
            "Canela",
            4,
            "hembra",
            "Tierna",
            "Juguetona",
            true,
            5,
            "newfoundland",
            "",
            "San Luis",
            "5kg",
            "https://images.dog.ceo/breeds/newfoundland/n02111277_4317.jpg"
        )

        val dog5 = DogEntity(
            5,
            "Perrito",
            4,
            "hembra",
            "Juguetona",
            "",
            false,
            3,
            "wolfhound",
            "irish",
            "Buenos Aires",
            "5kg",
            "https://images.dog.ceo/breeds/wolfhound-irish/n02090721_4376.jpg"
        )
        val dogsList = listOf(dog1, dog2, dog3, dog4, dog5)
        dogDao.insertAll(dogsList)
    }

    suspend fun clearDogs() {
        dogDao.deleteAllDogs()
    }

    suspend fun getAllDogs(): List<DogEntity> {
        insertDogs(emptyList())
        return dogDao.getAllDogs()
    }
    suspend fun getAllDogsWhereIsAdoptedFalse(): List<DogEntity> {
        insertDogs(emptyList())
        return dogDao.getAllDogsWhereIsAdoptedFalse()
    }
    suspend fun insertDog(dog: DogEntity) {
        val dogEntity = dog.toDatabase()
        dogDao.insert(dogEntity)
    }
}