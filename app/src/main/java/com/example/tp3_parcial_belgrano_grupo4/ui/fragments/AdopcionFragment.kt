package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.adapters.DogsAdapter
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.ui.viewModels.AdoptedViewModel
import javax.inject.Inject

class AdopcionFragment : Fragment() {
    @Inject
    lateinit var dogRepository: DogRepository
    private lateinit var recyclerView: RecyclerView
    private lateinit var dogsAdapter: DogsAdapter
    private val adoptedViewModel: AdoptedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        adoptedViewModel.onCreate()
        dogsAdapter = DogsAdapter(requireContext())

        return inflater.inflate(R.layout.adopcion_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isLoading = view.findViewById<View>(R.id.loading)
        recyclerView = view.findViewById(R.id.adopted_dogs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = dogsAdapter

        adoptedViewModel.dogsList.observe(viewLifecycleOwner) {
            dogsAdapter.setDogsList(it)
        }

        adoptedViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            isLoading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        adoptedViewModel.clear()
    }
}



