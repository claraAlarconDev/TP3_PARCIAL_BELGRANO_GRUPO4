package com.example.tp3_parcial_belgrano_grupo4.di

import com.example.tp3_parcial_belgrano_grupo4.core.Config
import com.example.tp3_parcial_belgrano_grupo4.core.InterceptorCustom
import com.example.tp3_parcial_belgrano_grupo4.data.network.interfaces.DogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private var client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorCustom)
    }.build()
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesDogsApiClient(retrofit: Retrofit): DogsApi {
        return retrofit.create(DogsApi::class.java)
    }

}