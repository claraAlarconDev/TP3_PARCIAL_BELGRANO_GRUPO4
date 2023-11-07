package com.example.tp3_parcial_belgrano_grupo4.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.core.Preferences
import com.example.tp3_parcial_belgrano_grupo4.data.models.DogModel
import com.squareup.picasso.Picasso

class DogsAdapter(private val context: Context, private val dogsList: List<DogModel>) :
    RecyclerView.Adapter<DogsAdapter.DogsViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setDogsList(dogsList: List<DogModel>) {
        (this.dogsList as ArrayList).clear()
        this.dogsList.addAll(dogsList)
        notifyDataSetChanged()
    }

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
                    // The toggle is enabled
                } else {
                    prefs.removeFavoriteDog(dog.idDog)
                    dogFavoriteToggle.isChecked = isChecked
                    dogFavoriteToggle.background = ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_toggle
                    );
                    // The toggle is disabled
                }
            }

        }
    }
}