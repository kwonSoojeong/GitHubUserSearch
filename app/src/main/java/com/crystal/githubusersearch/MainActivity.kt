package com.crystal.githubusersearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var fragmentManager : FragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val localFragment = LocalFragment()
        val apiFragment = APIFragment()
        replaceFragment(apiFragment)

        val bottomMenuView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomMenuView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.API-> replaceFragment(apiFragment)
                R.id.Local-> replaceFragment(localFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

}