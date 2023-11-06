package com.example.tp3_parcial_belgrano_grupo4.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.BreedDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.DogDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.FavoriteDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.ImageDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.OwnerDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.SavedDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.SubBreedDao
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.BreedEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.FavoriteEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.ImageEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.OwnerEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SavedEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SubBreedEntity

@Database(entities = [DogEntity:: class,BreedEntity:: class, FavoriteEntity:: class, ImageEntity:: class,
    OwnerEntity:: class, SavedEntity:: class, SubBreedEntity:: class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDogDao(): DogDao
    abstract fun getBreedDao(): BreedDao
    abstract fun getFavoriteDao(): FavoriteDao
    abstract fun getImageDao(): ImageDao
    abstract fun getOwnerDao(): OwnerDao
    abstract fun getSavedDao(): SavedDao
    abstract fun getSubBreedDao(): SubBreedDao



    }