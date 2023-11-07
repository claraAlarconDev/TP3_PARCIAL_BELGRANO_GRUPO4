package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels.DogsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.adapters.DogsAdapter
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.toModel
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val dogsViewModel: DogsViewModel by activityViewModels()

    @Inject
    lateinit var dogRepository: DogRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dogRecyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val dogLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        dogRecyclerView.layoutManager = dogLayoutManager
        val dogAdapter = DogsAdapter(requireContext(), mutableListOf())
        dogRecyclerView.adapter = dogAdapter

        lifecycleScope.launch {
            val dogs = dogRepository.getAllDogsWhereIsAdoptedFalse()
            dogAdapter.setDogsList(dogs.map { it.toModel() })
        }
    }
}
