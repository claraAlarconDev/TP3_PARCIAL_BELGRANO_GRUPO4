package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.adapters.DogsAdapter
import com.example.tp3_parcial_belgrano_grupo4.data.database.entities.toModel
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var dogRepository: DogRepository
    private lateinit var searchView: SearchView
    private lateinit var dogAdapter: DogsAdapter
    private lateinit var dogRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView = view.findViewById(R.id.searchView)
        dogRecyclerView = view.findViewById(R.id.recyclerView)
        val dogLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        dogRecyclerView.layoutManager = dogLayoutManager
         dogAdapter = DogsAdapter(requireContext())
        dogRecyclerView.adapter = dogAdapter

        lifecycleScope.launch {
            val dogs = dogRepository.getAllDogsWhereIsAdoptedFalse()
            dogAdapter.setDogsList(dogs.map { it.toModel() })
        }
        initListener()
    }

    private fun initListener() {
        searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            dogAdapter.filter(newText)
        }
        return false
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }
}
