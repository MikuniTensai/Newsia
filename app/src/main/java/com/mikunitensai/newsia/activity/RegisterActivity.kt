package com.mikunitensai.newsia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.app.ApiConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var edt_nama: EditText;
    lateinit var edt_email: EditText;
    lateinit var edt_phone: EditText;
    lateinit var edt_password: EditText;

    lateinit var btn_register:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register = findViewById(R.id.btn_register)
        edt_nama = findViewById(R.id.edt_nama)
        edt_email = findViewById(R.id.edt_email)
        edt_phone = findViewById(R.id.edt_phone)
        edt_password = findViewById(R.id.edt_password)

        btn_register.setOnClickListener {
            register()
        }
    }

    private fun register() {
        if (edt_nama.text.isEmpty()){
            edt_nama.error = "Kolom nama kosong"
            edt_nama.requestFocus()
            return
        } else if (edt_email.text.isEmpty()){
            edt_email.error = "Kolom email kosong"
            edt_email.requestFocus()
            return
        } else if (edt_phone.text.isEmpty()){
            edt_phone.error = "Kolom phone kosong"
            edt_phone.requestFocus()
            return
        } else if (edt_password.text.isEmpty()){
            edt_password.error = "Kolom password kosong"
            edt_password.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(
            edt_nama.text.toString(), edt_email.text.toString(), edt_phone.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}