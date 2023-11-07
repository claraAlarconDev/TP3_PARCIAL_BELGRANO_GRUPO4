package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.tp3_parcial_belgrano_grupo4.R
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingFragment : Fragment(R.layout.fragment_setting) {

    private lateinit var switchDarkMode: SwitchMaterial


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchDarkMode = view.findViewById(R.id.swDarkMode)


        // Configuracion del Modo Oscuro
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Habilita el Modo Oscuro
                (requireActivity() as AppCompatActivity).delegate.localNightMode =
                    AppCompatDelegate.MODE_NIGHT_YES
            } else {
                // Deshabilita el Modo Oscuro
                (requireActivity() as AppCompatActivity).delegate.localNightMode =
                    AppCompatDelegate.MODE_NIGHT_NO
            }
        }
    }
}