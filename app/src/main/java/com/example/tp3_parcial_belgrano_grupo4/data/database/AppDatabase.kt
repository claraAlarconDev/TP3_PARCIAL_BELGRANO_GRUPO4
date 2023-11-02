package com.example.tp3_parcial_belgrano_grupo4.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.BreedEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.DogEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.FavoriteEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.ImageEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.OwnerEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SavedEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.SubBreedEntity
import com.example.tp3_parcial_belgrano_grupo4.data.database.dao.BreedDao


@Database(entities = [DogEntity:: class,BreedEntity:: class, FavoriteEntity:: class, ImageEntity:: class,
    OwnerEntity:: class, SavedEntity:: class, SubBreedEntity:: class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDogDao(): DogDao
    abstract fun getBreedDao(): BreedDao
    abstract fun getFavoriteDao(): FavoriteDao
    abstract fun getImageDao(): ImageDao
    abstract fun getOwnerDao(): OwnerDao
    abstract fun getSavedDao(): SavedDao
    abstract fun getSubBreedDao(): SubBreedDao

    }