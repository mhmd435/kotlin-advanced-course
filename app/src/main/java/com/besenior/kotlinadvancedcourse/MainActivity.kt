package com.besenior.kotlinadvancedcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.besenior.kotlinadvancedcourse.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        setupnavigationComponent()
    }

    private fun setupnavigationComponent() {
        val navHostFragment:NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController



        val appBarConfiguration = AppBarConfiguration.Builder(setOf(R.id.homeFragment,R.id.planFragment))
            .setOpenableLayout(activityMainBinding.drawerLayout)
            .build()


        activityMainBinding.navView.setupWithNavController(navController)


        val popupMenu = PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu_bottom)
        val menu = popupMenu.menu
        activityMainBinding.bottomBar.setupWithNavController(menu,navController)


    }

}