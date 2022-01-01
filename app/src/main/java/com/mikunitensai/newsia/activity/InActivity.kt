package com.mikunitensai.newsia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.helper.SharedPreferences

class InActivity : AppCompatActivity() {

    lateinit var s:SharedPreferences
    lateinit var btnProsesLogin:Button
    lateinit var btnProsesRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in)

        btnProsesLogin = findViewById(R.id.btnProsesLogin)
        btnProsesRegister = findViewById(R.id.btnProsesRegister)

        s = SharedPreferences(this)

        mainButton()

    }

    private fun mainButton() {
        btnProsesLogin.setOnClickListener {
//            s.setStatusLogin(true)
            startActivity(Intent(this, LoginActivity::class.java))

        }

        btnProsesRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}