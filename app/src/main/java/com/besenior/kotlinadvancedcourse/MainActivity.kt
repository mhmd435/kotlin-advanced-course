package com.besenior.kotlinadvancedcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.besenior.kotlinadvancedcourse.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding:ActivityMainBinding
    lateinit var smoothBottomBar:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setupnavigationComponent()
    }

    private fun setupnavigationComponent() {
        val navHostFragment:NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        val popupMenu = PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu_bottom)
        val menu = popupMenu.menu
        activityMainBinding.bottomBar.setupWithNavController(menu,navController)
    }

}