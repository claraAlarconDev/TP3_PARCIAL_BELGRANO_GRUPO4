package com.example.tp3_parcial_belgrano_grupo4.data.repositories

import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogDao: DogDao
) {
    suspend fun insertDogs(dogs: List<DogEntity>) {
        insertMockDogs()
        withContext(Dispatchers.IO) {
            dogDao.insertAll(dogs)
        }
    }

    suspend fun insertMockDogs() {
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
                false,
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
                    false,
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
            val dog6 = DogEntity(
                6,
                "Tomate",
                4,
                "cattledog",
                "australian",
                "hembra",
                "Tierna",
                "Juguetona",
                false,
                5,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/cattledog-australian/IMG_9350.jpg"
            )
            val dog7 =
                DogEntity(
                    7,
                    "Atun",
                    4,
                    "bulldog",
                    "boston",
                    "macho",
                    "vagoneta",
                    "callejero",
                    false,
                    5,
                    "Merlo",
                    "7kg",
                    "https://images.dog.ceo/breeds/hound-ibizan/n02091244_3240.jpg"
                )
            val dog8 =
                DogEntity(
                    8,
                    "Tora",
                    4,
                    "dane",
                    "great",
                    "hembra",
                    "",
                    "",
                    false,
                    1,
                    "Mendoza",
                    "5kg",
                    "https://images.dog.ceo/breeds/hound-afghan/n02088094_6035.jpg"
                )
            val dog9 =
                DogEntity(
                    9, "Paca", 4,
                    "newfoundland",
                    "",
                    "hembra",
                    "Tierna",
                    "Juguetona",
                    false,
                    5,
                    "San Luis",
                    "5kg",
                    "https://images.dog.ceo/breeds/hound-afghan/n02088094_5504.jpg"
                )
            val dog10 = DogEntity(
                10,
                "Fury",
                4,
                "cavapoo",
                "",
                "hembra",
                "Juguetona",
                "",
                false,
                3,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/hound-basset/n02088238_10054.jpg"
            )
            val dog11 = DogEntity(
                11,
                "Maverick",
                4,
                "cavapoo",
                "",
                "hembra",
                "Juguetona",
                "",
                true,
                3,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/hound-basset/n02088238_10054.jpg"
            )
            val dog12 = DogEntity(
                12,
                "Territory",
                4,
                "cavapoo",
                "",
                "hembra",
                "Juguetona",
                "",
                true,
                3,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/hound-basset/n02088238_10054.jpg"
            )
            val dog13 = DogEntity(
                13,
                "Ka",
                4,
                "cavapoo",
                "",
                "hembra",
                "Juguetona",
                "",
                true,
                3,
                "Buenos Aires",
                "5kg",
                "https://images.dog.ceo/breeds/hound-basset/n02088238_10054.jpg"
            )
            val dogsList = listOf(
                dog1,
                dog2,
                dog3,
                dog4,
                dog5,
                dog6,
                dog7,
                dog8,
                dog9,
                dog10,
                dog11,
                dog12,
                dog13
            )
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

}