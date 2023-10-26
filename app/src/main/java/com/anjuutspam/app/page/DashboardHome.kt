package com.anjuutspam.app.page

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.anjuutspam.app.R
import com.anjuutspam.app.mysharedpreferences.MySharedPreference
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardHome : ComponentActivity() {
    private lateinit var mySharedPreference: MySharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mySharedPreference = MySharedPreference(this)
        setContentView(R.layout.dashboard_home)

        val bottomNav: BottomNavigationView = findViewById(R.id.layout_bottomnav)
        val homeMenu = bottomNav.menu.findItem(R.id.home)
        val profileMenu = bottomNav.menu.findItem(R.id.profile)
        val tampildata : TextView = findViewById(R.id.tampildata)
        profileMenu.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.profile) {
                val i = Intent(this@DashboardHome, DashboardProfile::class.java)
                startActivity(i)
                return@setOnMenuItemClickListener true
            }
            return@setOnMenuItemClickListener false
        }

        homeMenu.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.home) {
                // do nothing
                return@setOnMenuItemClickListener true
            }
            return@setOnMenuItemClickListener false
        }
    }
}
