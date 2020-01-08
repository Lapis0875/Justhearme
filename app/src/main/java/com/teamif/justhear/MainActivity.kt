package com.teamif.justhear

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.teamif.justhear.fragments.FragmentMore
import com.teamif.justhear.fragments.FragmentTimeline

class MainActivity : AppCompatActivity() {
    private val fragmentTimeline = FragmentTimeline()
    private val fragmentMore = FragmentMore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragmentTimeline).commitAllowingStateLoss()

        initToolBar()
        initBottomNavigation()
    }

    private fun initToolBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(R.string.timeline)
    }

    private fun initBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val trans = supportFragmentManager.beginTransaction()
            when (menuItem.itemId) {
                R.id.timeline -> trans.replace(R.id.frameLayout, fragmentTimeline).commitAllowingStateLoss()
                R.id.nav2 -> Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
                R.id.nav3 -> Toast.makeText(applicationContext, "3", Toast.LENGTH_SHORT).show()
                R.id.more -> trans.replace(R.id.frameLayout, fragmentMore).commitAllowingStateLoss()
            }

            true
        }
    }

    fun setActionBarTitle(title: String) {
        supportActionBar!!.title = title
    }

    fun setActionBarTitle(title: Int) {
        supportActionBar!!.setTitle(title)
}
}
