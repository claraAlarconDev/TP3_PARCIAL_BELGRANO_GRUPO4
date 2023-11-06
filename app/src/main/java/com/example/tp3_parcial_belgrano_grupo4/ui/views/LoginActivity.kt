package com.example.tp3_parcial_belgrano_grupo4.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val loginBtn = binding.loginBtn
        val userNameInput = binding.userNameLogin
        val userPhoneInput= binding.userPhoneLogin
        val userPassInput= binding.userPassLogin


        loginBtn.setOnClickListener {

            val userName = userNameInput.text.toString()
            val userPhone = userPhoneInput.text.toString()
            val userPass = userPassInput.text.toString()

            if(userName.isNotEmpty() && userPhone.isNotEmpty() && userPass.isNotEmpty() ) {

                val intent = Intent(applicationContext, MainActivity::class.java)

                intent.putExtra("user_name", userName)
                intent.putExtra("user_phone", userPhone)

                startActivity(intent)

                finish()
            } else if(userName.isEmpty()){
                showAlertDialog("Cuidado, el nombre de usuario esta vacio")
            } else if(userPhone.isEmpty()){
                showAlertDialog("Cuidado, no has ingresado un telefono")
            }else if(userPass.isEmpty()){
                showAlertDialog("Cuidado, el nombre de usuario esta vacio")
            }
        }

    }

    private fun showAlertDialog(message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
            .setMessage(message)
            .setPositiveButton("Entendido"){ dialog, which ->
                Toast.makeText(this, "Eso es! sigue intentandolo!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){ dialog, which ->
                dialog.dismiss()
            }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}