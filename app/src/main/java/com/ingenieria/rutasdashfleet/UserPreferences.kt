package com.ingenieria.rutasdashfleet

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {

    private val sharedPreferences:SharedPreferences =
        context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    var phone:String?
    get() = sharedPreferences.getString("phone", "")
    set(value) = editor.putString("phone", value).apply()


    var key:String?
    get() = sharedPreferences.getString("key", "")
    set(value) = editor.putString("key", value).apply()


}