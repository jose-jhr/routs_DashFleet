package com.ingenieria.rutasdashfleet

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ingenieria.rutasdashfleet.fragments.HomeFragment
import com.ingenieria.rutasdashfleet.fragments.RoutesFragment
import kotlinx.android.synthetic.main.activity_main_routes.*

class MainRoutes : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val routesFragment = RoutesFragment()

    lateinit var sharedPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_routes)
        window.statusBarColor = resources.getColor(R.color.color_app)
       // bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFragment(homeFragment)
        //get user shared preferences
        getUserSharePreferences()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_fragment -> {
                    loadFragment(homeFragment)
                    true
                }
                R.id.route_fragment -> {
                    loadFragment(routesFragment)
                    true
                }
                else -> false
            }
        }

        navBarMain.setOnClickListener {
            val popupMenu = PopupMenu(this, navBarMain)
            popupMenu.inflate(R.menu.botoom_navigation)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener { item->
                when (item.itemId) {
                    R.id.home_fragment -> {
                        loadFragment(homeFragment)
                        true
                    }
                    R.id.route_fragment -> {
                        loadFragment(routesFragment)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun getUserSharePreferences() {
        sharedPreferences = UserPreferences(this)
        txt_phone_user.text = sharedPreferences.phone
    }

    fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container,fragment)
        transaction.commit()
    }

}