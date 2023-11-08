package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.databinding.PublicacionFragmentBinding
import com.example.tp3_parcial_belgrano_grupo4.ui.viewModels.AdopcionViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PublicacionFragment : Fragment() {
    private lateinit var binding: PublicacionFragmentBinding
    private val viewModel: AdopcionViewModel by viewModels()
    private var sexo = "Macho"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PublicacionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewModelScope.launch {
            viewModel.obtenerRazas()
        }
        binding.botonMacho.setOnClickListener{
            sexo = "Macho"
        }

        binding.botonHembra.setOnClickListener {
            sexo = "Hembra"
        }

        binding.spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val razaSeleccionada = parent?.getItemAtPosition(position).toString()
                viewModel.viewModelScope.launch {
                    viewModel.obtenerSubrazas(razaSeleccionada)
                    val tieneSubrazas = viewModel.tieneSubrazas(razaSeleccionada)

                    if (!tieneSubrazas) {
                        binding.spinnerSubraza.visibility = View.VISIBLE
                        binding.spinnerSubraza.prompt = ""
                    } else {
                        binding.spinnerSubraza.visibility = View.VISIBLE
                        binding.spinnerSubraza.prompt = "El perro no tiene sub-raza"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada
            }
        }

        viewModel.razas.observe(viewLifecycleOwner) { razasList ->
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                razasList
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerRaza.adapter = adapter
        }

        viewModel.subrazas.observe(viewLifecycleOwner) { subrazasList ->
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                subrazasList
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerSubraza.adapter = adapter
        }

        viewModel.cargarProvincias(requireContext())

        viewModel.provincias.observe(viewLifecycleOwner) { provinciasList ->
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                provinciasList
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerProvincia.adapter = adapter
        }

        binding.botonPublicar.setOnClickListener {
            val nombre = binding.editTextNombre.text.toString()
            val edad = binding.editTextEdad.text.toString().toIntOrNull() ?: 0
            val descripcion = binding.editTextDescripcion.text.toString()
            val observaciones = binding.editTextObservaciones.text.toString()
            val idOwner = binding.editTextUserId.text.toString().toIntOrNull() ?: 0
            val raza = binding.spinnerRaza.selectedItem.toString()
            val subraza = binding.spinnerSubraza.selectedItem?.toString() ?: ""
            val ubicacion = binding.spinnerProvincia.selectedItem.toString()
            val peso = binding.editTextPeso.text.toString()
            val fotos = binding.editTextFoto1.text.toString()

            // Lanzar una corutina en el viewModelScope
            viewModel.viewModelScope.launch {
                viewModel.insertarNuevoPerro(
                    nombre, edad, sexo, descripcion, observaciones,
                    idOwner, raza, subraza, ubicacion, peso, fotos
                )

                Toast.makeText(requireContext(), "Se ha publicado un perro en adopción", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.publicacion)
            }
        }

    }

}