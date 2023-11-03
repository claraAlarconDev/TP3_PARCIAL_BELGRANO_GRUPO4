package com.example.tp3_parcial_belgrano_grupo4.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3_parcial_belgrano_grupo4.R

class AdoptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption)

        botonPublicar.setOnClickListener {
            // Lógica para publicar el perro en adopción
        }
    }
}