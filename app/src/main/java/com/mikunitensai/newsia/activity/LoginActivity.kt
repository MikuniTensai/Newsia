package com.mikunitensai.newsia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.helper.SharedPreferences

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPreferences
    lateinit var btnProsesLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPreferences(this)

        btnProsesLogin = findViewById(R.id.btnProsesLogin)
        btnProsesLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}