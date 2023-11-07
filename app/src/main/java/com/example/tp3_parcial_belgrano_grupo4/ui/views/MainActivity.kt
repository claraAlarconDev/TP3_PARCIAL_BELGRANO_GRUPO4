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
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        val intent = intent
        val userName = intent.getStringExtra("user_name")
        val userPhone = intent.getStringExtra("user_phone")



        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        drawer = findViewById(R.id.viewContainer)
        navigationView = findViewById(R.id.nav_view)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )


        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)




        NavigationUI.setupWithNavController(navigationView, navHostFragment.navController)

        bottomNavView = findViewById(R.id.bottom_bar)
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)


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

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
