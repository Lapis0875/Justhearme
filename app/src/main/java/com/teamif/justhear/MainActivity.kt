package com.teamif.justhear

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var mDrawer: DrawerLayout? = null
    private var mActionBarDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
    }

    private fun initDrawer() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        mDrawer = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        mActionBarDrawerToggle = ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.open, R.string.closed)
        mDrawer!!.addDrawerListener(mActionBarDrawerToggle!!)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_1 -> Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
                R.id.nav_2 -> Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
                R.id.nav_3 -> Toast.makeText(applicationContext, "3", Toast.LENGTH_SHORT).show()
            }

            mDrawer!!.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mActionBarDrawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mActionBarDrawerToggle!!.onConfigurationChanged(newConfig)
    }

    override fun onBackPressed() {
        if (mDrawer!!.isDrawerOpen(GravityCompat.START)) {
            mDrawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
