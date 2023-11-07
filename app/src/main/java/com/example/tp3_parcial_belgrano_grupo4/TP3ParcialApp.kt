package com.example.tp3_parcial_belgrano_grupo4

import android.app.Application
import com.example.tp3_parcial_belgrano_grupo4.core.Config
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp

class TP3ParcialApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Config.baseUrl = resources.getString((R.string.baseUrl))
    }
}