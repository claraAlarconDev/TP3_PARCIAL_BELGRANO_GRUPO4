package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.adapters.DogsAdapter
import com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels.DogsViewModel

@AndroidEntryPoint
class DogsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dogsAdapter: DogsAdapter
    private val dogsViewModel: DogsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("DogsFragment", "onCreateView")

        dogsViewModel.onCreate()
        dogsAdapter = DogsAdapter(requireContext(), mutableListOf())

        return inflater.inflate(R.layout.dogs_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isLoading = view.findViewById<View>(R.id.loading)
        recyclerView = view.findViewById(R.id.rec_dogs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = dogsAdapter

        dogsViewModel.dogsList.observe(viewLifecycleOwner) {
            dogsAdapter.setDogsList(it)
        }

        dogsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            isLoading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        dogsViewModel.clear()
    }
}