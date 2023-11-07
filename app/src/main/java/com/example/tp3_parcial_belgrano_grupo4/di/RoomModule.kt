package com.example.tp3_parcial_belgrano_grupo4.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tp3_parcial_belgrano_grupo4.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val APP_DATABASE_NAME = "app_database"

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    @Singleton
    @Provides
    fun provideDogDao(db: AppDatabase) = db.getDogDao()

    @Singleton
    @Provides
    fun provideBreedDao(db: AppDatabase) = db.getBreedDao()

    @Singleton
    @Provides
    fun provideSubBreedDao(db: AppDatabase) = db.getSubBreedDao()

    @Singleton
    @Provides
    fun provideImageDao(db: AppDatabase) = db.getImageDao()

    @Singleton
    @Provides
    fun provideOwnerDao(db: AppDatabase) = db.getOwnerDao()

    @Singleton
    @Provides
    fun provideFavoriteDao(db: AppDatabase) = db.getFavoriteDao()

    @Singleton
    @Provides
    fun provideSavedDao(db: AppDatabase) = db.getSavedDao()

}
