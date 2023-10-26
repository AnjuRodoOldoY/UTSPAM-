package com.anjuutspam.app.page

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.anjuutspam.app.R
import com.anjuutspam.app.mysharedpreferences.MySharedPreference
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardProfile : ComponentActivity() {
    private lateinit var mySharedPreference : MySharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mySharedPreference = MySharedPreference(this)
        setContentView(R.layout.dashboard_profile)
        val logoutButton : Button = findViewById(R.id.logout)
        val bottomNav : BottomNavigationView = findViewById(R.id.layout_bottomnav)
        val homeMenu = bottomNav.menu.findItem(R.id.home)
        val profileMenu = bottomNav.menu.findItem(R.id.profile)
        logoutButton.setOnClickListener{
            mySharedPreference.saveIsLogin(false)
            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show()
            val i = Intent(this@DashboardProfile, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
        homeMenu.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.home) { // Check for the "home" item
                val i = Intent(this@DashboardProfile, DashboardHome::class.java)
                startActivity(i)
                return@setOnMenuItemClickListener true
            }
            return@setOnMenuItemClickListener false
        }
    }
}