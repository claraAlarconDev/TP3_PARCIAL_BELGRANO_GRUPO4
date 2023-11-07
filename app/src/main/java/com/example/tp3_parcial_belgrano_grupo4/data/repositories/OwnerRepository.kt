package com.example.tp3_parcial_belgrano_grupo4.data.repositories
import android.annotation.SuppressLint
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.OwnerDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.OwnerImageName
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.OwnerEntity
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogApiResponse
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Owner
import com.example.tp3_parcial_belgrano_grupo4.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OwnerRepository @Inject constructor(
    private val ownerDao: OwnerDao
){


    suspend fun insertOwners(owners: List<OwnerEntity>) {
        withContext(Dispatchers.IO) {
            ownerDao.insertAll(owners)
        }
    }


    suspend fun deleteAllOwners(){
        ownerDao.deleteAllOwners()
    }

    @SuppressLint("SuspiciousIndentation")
    suspend fun getAllOwners(): List<Owner>{
      val response: List<OwnerEntity> = ownerDao.getAllOwners()
        return response.map{it.toDomain()}
    }

    suspend fun getOwnerById(id: Int) : Owner {
        val response: OwnerEntity = ownerDao.getOwnerById(id)
        return response.toDomain()
    }

    suspend fun getImageAndName(id: Int) : OwnerImageName {
        val response: OwnerImageName = ownerDao.getImageAndName(id)
        return response //find a way to send it toDomain
    }

    suspend fun getOwnerAttribute(id: Int, att: String) : String {
        val response: String = ownerDao.getOwnerAttribute(id, att)
        return if(response.isEmpty()){
            "No existe el atributo que busca"
        }else {
            response
        }
    }

    suspend fun updateImage(id: Int, imageUrl: String) {
            if (id < 0) {
                throw Exception("El id no es valido")
            } else if(imageUrl.isEmpty()){
                throw Exception("La url de la imagen no es valida")
            } else {
                ownerDao.updateImage(id, imageUrl)
            }
    }

}

