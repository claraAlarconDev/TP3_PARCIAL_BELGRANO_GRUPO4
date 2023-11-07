package com.example.tp3_parcial_belgrano_grupo4.ui.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.data.repositories.DogRepository
import com.example.tp3_parcial_belgrano_grupo4.ui.fragments.ImageSliderFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DogDetailActivity : AppCompatActivity() {
    private lateinit var dogRepository: DogRepository
    private lateinit var adoptButton: Button
    private lateinit var btnDetailCall: ImageButton
    private lateinit var favButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, ImageSliderFragment())
        transaction.commit()



        val dogId = intent.getIntExtra("dogId", 0)



        suspend fun getDog(dogId:Int){
            dogRepository.getDogById(dogId)
        }



        adoptButton = findViewById(R.id.btnAdopt)
        btnDetailCall = findViewById(R.id.BtnCall)
        favButton = findViewById(R.id.btnFav)
        var countAdopt = 0

        adoptButton.setOnClickListener{

            Toast.makeText(this, "Adoptaste a Firulais", Toast.LENGTH_LONG).show()
        }


        favButton.setOnClickListener{

            if(countAdopt==0){
                Toast.makeText(this, "Agregado a Favoritos",Toast.LENGTH_LONG).show()
                countAdopt++
            }else{
                Toast.makeText(this, "Quitado de Favoritos",Toast.LENGTH_LONG).show()
                countAdopt--
            }

        }

        btnDetailCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:111"))
            startActivity(intent)
            finish()
        }


    }
}