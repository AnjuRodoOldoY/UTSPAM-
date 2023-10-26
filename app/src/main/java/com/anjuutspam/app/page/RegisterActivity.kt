package com.anjuutspam.app.page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.anjuutspam.app.MainActivity
import com.anjuutspam.app.R
import com.anjuutspam.app.mysharedpreferences.MySharedPreference

class RegisterActivity : ComponentActivity() {
    private lateinit var mySharedPreference : MySharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)
        mySharedPreference = MySharedPreference(this)
        val goBack : TextView = findViewById(R.id.fromregister_toafter)
        val toLogin : TextView = findViewById(R.id.fromregister_tologin)
        val editUser : EditText = findViewById(R.id.user_regis)
        val editPass : EditText = findViewById(R.id.pass_regis)
        val submitRegister : Button = findViewById(R.id.submit_register)
        goBack.setOnClickListener{
            val i = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }
        toLogin.setOnClickListener {
            val i = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
        submitRegister.setOnClickListener{
            if(editUser.text.isEmpty() && editPass.text.isEmpty()){
                Toast.makeText(this, "Please input username and password", Toast.LENGTH_SHORT).show()
            }
            else{
                val userToSave = editUser.text.toString()
                val passToSave = editPass.text.toString()
                mySharedPreference.saveRegister(userToSave, passToSave)
                Toast.makeText(this, "Successfully Register!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onResume() {
        super.onResume()
        if(mySharedPreference.getIsLogin()){
            Toast.makeText(this, "Already Login!", Toast.LENGTH_SHORT).show()
            val i = Intent(this@RegisterActivity, DashboardProfile::class.java)
            startActivity(i)
            finish()
        }
    }
}