package com.anjuutspam.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.anjuutspam.app.page.LoginActivity
import com.anjuutspam.app.page.RegisterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.after_splash)
        val toLogin : Button = findViewById(R.id.fromafter_tologin)
        val toRegister : Button = findViewById(R.id.fromafter_toregister)

        toLogin.setOnClickListener{
            val i = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
        toRegister.setOnClickListener{
            val i = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
