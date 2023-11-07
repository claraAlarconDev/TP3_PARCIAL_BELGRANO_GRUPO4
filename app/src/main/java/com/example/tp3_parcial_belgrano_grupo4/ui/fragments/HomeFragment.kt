package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.annotation.SuppressLint
import android.app.SearchManager
import android.database.Cursor
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter
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
class HomeFragment : Fragment(){

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
        initializeSearchView()
    }

    fun initializeSearchView(){
        val from = arrayOf(SearchManager.SUGGEST_COLUMN_TEXT_1)
        val to = intArrayOf(R.id.searchItemID)
        val cursorAdapter = SimpleCursorAdapter(context, R.layout.suggestion_item_layout, null, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)
        searchView.suggestionsAdapter = cursorAdapter
        val cursor =
            MatrixCursor(arrayOf(BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1))

        cursorAdapter.changeCursor(cursor)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                dogAdapter.filter(cursorAdapter, newText, false)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })
        searchView.setOnSuggestionListener(object : SearchView.OnSuggestionListener {
            @SuppressLint("Range")
            override fun onSuggestionClick(position: Int): Boolean {
                val cursor = searchView.suggestionsAdapter.getItem(position) as Cursor
                val selection =
                    cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1))
                searchView.setQuery(selection, false)
                dogAdapter.filter(cursorAdapter, selection, true)
                return true
            }

            override fun onSuggestionSelect(position: Int): Boolean {
                return false
            }
        })
    }


}
