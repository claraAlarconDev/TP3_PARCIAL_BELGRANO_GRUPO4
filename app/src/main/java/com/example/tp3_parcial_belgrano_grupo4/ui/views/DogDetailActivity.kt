package com.example.tp3_parcial_belgrano_grupo4.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.ui.fragments.ImageSliderFragment

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)



        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, ImageSliderFragment())
        transaction.commit()

        val adoptButton: Button = findViewById<Button>(R.id.btnAdopt)

        adoptButton.setOnClickListener{
            Toast.makeText(this, "Adoptaste a Firulais", Toast.LENGTH_LONG).show()
        }

        val favButton: ImageButton = findViewById<ImageButton>(R.id.btnFav)

        favButton.setOnClickListener{
            Toast.makeText(this, "Agregado a Favoritos", Toast.LENGTH_LONG).show()
        }



        var countAdopt= 0
        favButton.setOnClickListener{

            if(countAdopt==0){
                Toast.makeText(this, "Agregado a Favoritos",Toast.LENGTH_LONG).show()
                countAdopt++
            }else{
                Toast.makeText(this, "Quitado de Favoritos",Toast.LENGTH_LONG).show()
                countAdopt--
            }

        }
    }
}