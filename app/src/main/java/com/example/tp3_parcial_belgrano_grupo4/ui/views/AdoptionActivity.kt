package com.example.tp3_parcial_belgrano_grupo4.ui.views

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tp3_parcial_belgrano_grupo4.databinding.ActivityAdoptionBinding
import com.example.tp3_parcial_belgrano_grupo4.domain.model.Dog
import com.example.tp3_parcial_belgrano_grupo4.ui.views.viewModels.AdopcionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdoptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdoptionBinding

    private val viewModel: AdopcionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdoptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectRazaButton.setOnClickListener {
            viewModel.obtenerRazas()
        }

        binding.spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val razaSeleccionada = parent?.getItemAtPosition(position).toString()
                viewModel.obtenerSubrazas(razaSeleccionada)
            }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada
            }
        }

        viewModel.razas.observe(this) { razasList ->
            val adapter = ArrayAdapter(
                this@AdoptionActivity,
                android.R.layout.simple_spinner_item,
                razasList
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerRaza.adapter = adapter
        }

        viewModel.subrazas.observe(this) { subrazasList ->
            val adapter = ArrayAdapter(
                this@AdoptionActivity,
                android.R.layout.simple_spinner_item,
                subrazasList
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerSubraza.adapter = adapter
        }
        viewModel.cargarProvincias(applicationContext)

        viewModel.provincias.observe(this) { provinciasList ->
            val adapter = ArrayAdapter(
                this@AdoptionActivity,
                android.R.layout.simple_spinner_item,
                provinciasList
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerProvincia.adapter = adapter
        }

        binding.botonPublicar.setOnClickListener {
            val nombre = binding.editTextNombre.text.toString()
            val edad = binding.editTextEdad.text.toString().toIntOrNull() ?: 0
            val sexo = binding.spinnerSexo.selectedItem.toString()
            val descripcion = binding.editTextDescripcion.text.toString()
            val observaciones = binding.editTextObservaciones.text.toString()
            val idOwner = binding.editTextUserId.text.toString().toIntOrNull() ?: 0
            val raza = binding.spinnerRaza.selectedItem.toString()
            val subraza = binding.spinnerSubraza.selectedItem.toString()
            val ubicacion = binding.spinnerProvincia.selectedItem.toString()
            val peso = binding.editTextPeso.text.toString()
            val nuevoPerro = Dog(
                name = nombre,
                age = edad,
                sex = sexo,
                description = descripcion,
                observations = observaciones,
                adopted = false,
                idOwner = idOwner,
                breed = raza,
                subBreed = subraza,
                location = ubicacion,
                weight = peso
            )

            viewModel.insertarNuevoPerro(nuevoPerro)
        }

    }
}
