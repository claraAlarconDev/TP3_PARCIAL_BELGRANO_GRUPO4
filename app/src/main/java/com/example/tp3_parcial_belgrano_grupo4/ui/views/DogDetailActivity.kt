package com.example.tp3_parcial_belgrano_grupo4.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tp3_parcial_belgrano_grupo4.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)
    }
}