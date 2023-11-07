package com.example.tp3_parcial_belgrano_grupo4.adapters

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.database.MatrixCursor
import android.provider.BaseColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.content.ContextCompat
import androidx.cursoradapter.widget.SimpleCursorAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.core.Preferences
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.example.tp3_parcial_belgrano_grupo4.ui.views.DogDetailActivity
import com.squareup.picasso.Picasso
import java.util.Locale
import java.util.stream.Collectors


class DogsAdapter( private val context: Context) :
    RecyclerView.Adapter<DogsAdapter.DogsViewHolder>() {
    private var dogsList: ArrayList<DogModel> = ArrayList()
    private var originalDogList: ArrayList<DogModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dog = dogsList[position]
        holder.bind(dog)
    }

    override fun getItemCount(): Int {
        return dogsList.size
    }

    inner class DogsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.dog_name)
        private val breed: TextView = itemView.findViewById(R.id.breed)
        private val subBreed: TextView = itemView.findViewById(R.id.sub_breed)
        private val ageAndGender: TextView = itemView.findViewById(R.id.age_gender)
        private val dogImage: ImageView = itemView.findViewById(R.id.image_dog)
        private val dogFavoriteToggle: ToggleButton = itemView.findViewById(R.id.dog_fav)

        fun bind(dog: DogModel) {
            val prefs = Preferences(context)
            val isFav = prefs.isFavoriteDog(dog.idDog)
            val textAgeGender = dog.age.toString() + " años, " + dog.gender
            name.text = dog.name
            breed.text = dog.breed
            subBreed.text = dog.subBreed
            ageAndGender.text = textAgeGender
            Picasso.get().load(dog.img).into(dogImage)
            dogFavoriteToggle.background = ContextCompat.getDrawable(
                context,
                R.drawable.ic_toggle_bg
            );
            dogFavoriteToggle.isChecked = isFav

            dogFavoriteToggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    prefs.addFavoriteDog(dog.idDog)
                    dogFavoriteToggle.isChecked = isChecked
                    dogFavoriteToggle.background = ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_toggle_bg
                    );
                } else {
                    prefs.removeFavoriteDog(dog.idDog)
                    dogFavoriteToggle.isChecked = isChecked
                    dogFavoriteToggle.background = ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_toggle
                    );
                }
            }

            dogImage.setOnClickListener {
                val intent = Intent(context, DogDetailActivity::class.java)
                intent.putExtra("idDog", dog.idDog.toString())
                context.startActivity(intent)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filter(cursorAdapter: SimpleCursorAdapter, strSearch: String?, isSelection: Boolean) {
        val cursor =
            MatrixCursor(arrayOf(BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1))

        strSearch?.let {
            originalDogList.forEachIndexed { index, dog ->
                if (dog.breed.contains(strSearch, true))
                    cursor.addRow(arrayOf(index, dog.breed))
                if (dog.subBreed.contains(strSearch, true))
                    cursor.addRow(arrayOf(index, dog.subBreed))
            }
        }
        if (!isSelection)
            cursorAdapter.changeCursor(cursor)

        filterDogList(strSearch)

        notifyDataSetChanged()
    }

    fun filterDogList(strSearch: String?) {
        if (strSearch == null || strSearch.isEmpty()) {
            dogsList.clear()
            dogsList.addAll(originalDogList)
        } else {
            dogsList.clear()
            val collect: List<DogModel> = originalDogList.stream()
                .filter {
                    it.breed.lowercase(Locale.ROOT).contains(strSearch) ||
                            it.subBreed.lowercase(Locale.ROOT).contains(strSearch)
                }
                .collect(Collectors.toList())
            dogsList.addAll(collect)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDogsList(dogsList: List<DogModel>) {
        this.dogsList.clear()
        this.dogsList.addAll(dogsList)
        this.originalDogList.clear()
        this.originalDogList.addAll(dogsList)
        notifyDataSetChanged()
    }
}