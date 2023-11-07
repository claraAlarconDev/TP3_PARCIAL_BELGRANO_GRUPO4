package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.adapters.FavDogsAdapter
import com.example.tp3_parcial_belgrano_grupo4.core.Preferences
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.toModel
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels.DogsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoritosFragment : Fragment() {
    @Inject
    lateinit var dogRepository: DogRepository
    private lateinit var recyclerView: RecyclerView
    private lateinit var favDogsAdapter: FavDogsAdapter
    private val dogsViewModel: DogsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("FavoritosFragment", "onCreateView")

        dogsViewModel.onCreate()
        favDogsAdapter = FavDogsAdapter(requireContext())

        return inflater.inflate(R.layout.favoritos_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rec_dogs)
        val dogLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = dogLayoutManager
        favDogsAdapter = FavDogsAdapter(requireContext())
        recyclerView.adapter = favDogsAdapter

        lifecycleScope.launch {
            val dogs = dogRepository.getAllDogsWhereIsAdoptedFalse()
            val prefs = Preferences(requireContext())
            val favList = prefs.getUserFavouriteDogs()

            favDogsAdapter.setDogsList(dogs.filter { favList.contains(it.idDog) }
                .map { it.toModel() })
        }
    }
}