package com.example.tp3_parcial_belgrano_grupo4.ui.views


import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.tp3_parcial_belgrano_grupo4.R
import com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.squareup.picasso.Picasso


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var profileViewModel: ProfileViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        val intent = intent
        val userName = intent.getStringExtra("user_name")
        val userPhone = intent.getStringExtra("user_phone")

        val fragmentManager = supportFragmentManager

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navHostFragment = fragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        setupDrawerLayout()

        val navHeaderUserName = navigationView.getHeaderView(0).findViewById<TextView>(R.id.profile_name_header)
        val navHeaderUserImage = navigationView.getHeaderView(0).findViewById<ImageView>(R.id.profile_image_header)

        if (userName != null && userPhone != null) {
            profileViewModel.setUserName(userName)
            profileViewModel.setUserPhone(userPhone)
        }

        profileViewModel.userImageUrl.observe(this, Observer { imageUrl ->
            Picasso.get().load(imageUrl).into(navHeaderUserImage)
        })

        profileViewModel.userName.observe(this, Observer { username ->
            navHeaderUserName.text = username
        })

    }
    private fun setupDrawerLayout(){
        val navController = navHostFragment.navController
        navigationView.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController,drawerLayout)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.nav_home) {
                supportActionBar?.setHomeAsUpIndicator(R.drawable.menu_24)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }
}
