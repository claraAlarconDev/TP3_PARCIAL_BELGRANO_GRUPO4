package com.example.tp3_parcial_belgrano_grupo4.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.tp3_parcial_belgrano_grupo4.R

class AdoptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption)

        val razaSpinner = findViewById<Spinner>(R.id.spinnerRaza)
        val subrazaSpinner = findViewById<Spinner>(R.id.spinnerSubraza)

        razaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val razaSeleccionada = resources.getStringArray(R.array.razas)[position]
                val idArraySubraza =
                    resources.getIdentifier("subrazas_$razaSeleccionada", "array", packageName)

                // Cargar las subrazas correspondientes
                val subrazas = resources.getStringArray(idArraySubraza)
                val adapter = ArrayAdapter(
                    this@AdoptionActivity,
                    android.R.layout.simple_spinner_item,
                    subrazas
                )
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                subrazaSpinner.adapter = adapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada
            }
        }
    }
}