package com.anjuutspam.app.mysharedpreferences

import android.content.Context
import android.content.SharedPreferences

class MySharedPreference(context: Context) : SharedPreferences by context.getSharedPreferences("AnjuPrefs", Context.MODE_PRIVATE) {
    private val prefsName = "AnjuPrefs"
    private val userKey = "username"
    private val passKey = "password"
    private val isloginKey = "islogin"
    private val sharedPreferences : SharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    private val editor : SharedPreferences.Editor = sharedPreferences.edit()

    fun saveRegister(username: String, password: String){
        editor.putString(userKey, username)
        editor.putString(passKey, password)
        editor.apply()
    }
    fun saveIsLogin(login: Boolean){
        editor.putBoolean(isloginKey, login)
        editor.apply()
    }
    fun getUser(): String?{
        return sharedPreferences.getString(userKey, null)
    }
    fun getPass(): String?{
        return sharedPreferences.getString(passKey, null)
    }
    fun getIsLogin(): Boolean {
        return  sharedPreferences.getBoolean(isloginKey, null == true)
    }
}