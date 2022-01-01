package com.mikunitensai.newsia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.helper.SharedPreferences

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPreferences(this)
    }
}