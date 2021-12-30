package com.mikunitensai.newsia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mikunitensai.newsia.fragment.AccountFragment
import com.mikunitensai.newsia.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    val fragmentAccount: Fragment = AccountFragment()
    val fragmentHome: Fragment = HomeFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu:Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNav()
    }

    fun setupBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit();
        fm.beginTransaction().add(R.id.container, fragmentAccount).hide(fragmentAccount).commit();

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    Log.d("Response","Home")
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_account -> {
                    Log.d("Response","Account")
                    callFragment(1, fragmentAccount)
                }
            }
            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment){
        Log.d("Response","Account")
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragmentAccount
    }
}