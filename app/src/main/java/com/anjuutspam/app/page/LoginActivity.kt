package com.anjuutspam.app.page

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.anjuutspam.app.MainActivity
import com.anjuutspam.app.R
import com.anjuutspam.app.mysharedpreferences.MySharedPreference

class LoginActivity : ComponentActivity() {
    private lateinit var mySharedPreference : MySharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        mySharedPreference = MySharedPreference(this)
        val goBack : TextView = findViewById(R.id.fromlogin_toafter)
        val toRegister : TextView = findViewById(R.id.fromlogin_toregister)
        val editUser : EditText = findViewById(R.id.user_login)
        val editPass : EditText = findViewById(R.id.pass_login)
        val submitLogin : Button = findViewById(R.id.submit_login)
        goBack.setOnClickListener{
            val i = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }
        val submitButton = findViewById<Button>(R.id.submit_login)
        submitButton.setOnClickListener {
            // Add your button click logic here
        }
        toRegister.setOnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
            finish()
        }
        submitLogin.setOnClickListener{
            if(editUser.text.isEmpty() && editPass.text.isEmpty()){
                Toast.makeText(this, "Please input username and password", Toast.LENGTH_SHORT).show()
            }
            else{
                val userToLogin = editUser.text.toString()
                val passToLogin = editPass.text.toString()
                if(mySharedPreference.getUser()==userToLogin && mySharedPreference.getPass()==passToLogin){
                    Toast.makeText(this, "Successfully Login!", Toast.LENGTH_SHORT).show()
                    mySharedPreference.saveIsLogin(true)
                    val i = Intent(this@LoginActivity, DashboardHome::class.java)
                    startActivity(i)
                    finish()
                }
                else{
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if(mySharedPreference.getIsLogin()){
            Toast.makeText(this, "Already Login!", Toast.LENGTH_SHORT).show()
            val i = Intent(this@LoginActivity, DashboardHome::class.java)
            startActivity(i)
            finish()
        }
    }
}