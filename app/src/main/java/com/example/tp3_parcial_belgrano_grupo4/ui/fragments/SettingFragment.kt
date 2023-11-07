package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp3_parcial_belgrano_grupo4.databinding.FragmentSettingBinding
import com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels.SettingViewModel

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val settingViewModel =
            ViewModelProvider(this).get(SettingViewModel:: class.java)

        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onDestroyView()
        _binding = null
    }

}