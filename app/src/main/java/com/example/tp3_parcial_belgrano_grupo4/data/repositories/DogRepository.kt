package com.example.tp3_parcial_belgrano_grupo4.data.repositories

import androidx.lifecycle.LiveData
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogDao: DogDao
) {
    suspend fun insertDogs(dogs: List<DogEntity>) {
        withContext(Dispatchers.IO) {
            val dog1 = DogEntity(
                1,
                "Milu",
                4,
                "cattledog",
                "australian",
                "hembra",
                "Tierna",
                "Juguetona",
                true,
                5,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/cattledog-australian/IMG_9350.jpg"
            )
            val dog2 =
                DogEntity(
                    2,
                    "Cachirulo",
                    4,
                    "australian",
                    "",
                    "macho",
                    "vagoneta",
                    "callejero",
                    false,
                    5,
                    "Merlo",
                    "7kg",
                    "https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"
                )
            val dog3 =
                DogEntity(
                    3,
                    "Rayo",
                    4,
                    "beagle",
                    "",
                    "hembra",
                    "",
                    "",
                    false,
                    1,
                    "Mendoza",
                    "5kg",
                    "https://images.dog.ceo/breeds/papillon/n02086910_4999.jpg"
                )
            val dog4 =
                DogEntity(
                    4, "Canela", 4,
                    "newfoundland",
                    "",
                    "hembra",
                    "Tierna",
                    "Juguetona",
                    true,
                    5,
                    "San Luis",
                    "5kg",
                    "https://images.dog.ceo/breeds/newfoundland/n02111277_4317.jpg"
                )
            val dog5 = DogEntity(
                5,
                "Perrito",
                4,
                "wolfhound",
                "irish",
                "hembra",
                "Juguetona",
                "",
                false,
                3,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/wolfhound-irish/n02090721_4376.jpg"
            )
            val dogsList = listOf(dog1, dog2, dog3, dog4, dog5)
            dogDao.insertAll(dogsList)
        }
    }

    suspend fun clearDogs() {
        dogDao.deleteAllDogs()
    }

    suspend fun getAllDogs(): List<DogEntity> {
        withContext(Dispatchers.IO) {
            insertDogs(emptyList())
        }
        return dogDao.getAllDogs()
    }
    suspend fun getAllDogsWhereIsAdoptedFalse(): List<DogEntity> {
        withContext(Dispatchers.IO) {
            insertDogs(emptyList())
        }
        return dogDao.getAllDogsWhereIsAdoptedFalse()
    }

    suspend fun updateDogAdoptionStatus(dogId: Int, isAdopted: Boolean) {
        dogDao.updateAdoptionStatus(dogId, isAdopted)
    }

    suspend fun getDogById(dogId: Int): DogEntity {
       return dogDao.getDogById(dogId)
    }

    suspend fun getAllDogsWhereIsAdoptedTrue(): List<DogEntity> {
        insertDogs(emptyList())
        return dogDao.getAllDogsWhereIsAdoptedTrue()
    }
}