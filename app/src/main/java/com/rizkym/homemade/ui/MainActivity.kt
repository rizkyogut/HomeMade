package com.rizkym.homemade.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rizkym.homemade.R
import com.rizkym.homemade.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    val homeFragment = HomeFragment()
                    switchFragment(homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.category -> {
                    val categoryFragment = CategoryFragment()
                    switchFragment(categoryFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.area -> {
                    val areaFragment = AreaFragment()
                    switchFragment(areaFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.favorite -> {
                    val favoriteFragment = FavoriteFragment()
                    switchFragment(favoriteFragment)
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()
    }
}