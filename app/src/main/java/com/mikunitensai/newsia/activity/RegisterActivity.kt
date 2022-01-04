package com.mikunitensai.newsia.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.mikunitensai.newsia.MainActivity
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.app.ApiConfig
import com.mikunitensai.newsia.helper.SharedPreferences
import com.mikunitensai.newsia.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var edt_nama: EditText
    lateinit var edt_email: EditText
    lateinit var edt_phone: EditText
    lateinit var edt_password: EditText

    lateinit var btn_register:Button
    lateinit var btn_google:RelativeLayout
    lateinit var pb:ProgressBar

    lateinit var s:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        s = SharedPreferences(this)

        btn_register = findViewById(R.id.btn_register)
        btn_google = findViewById(R.id.btn_google)
        edt_nama = findViewById(R.id.edt_nama)
        edt_email = findViewById(R.id.edt_email)
        edt_phone = findViewById(R.id.edt_phone)
        edt_password = findViewById(R.id.edt_password)
        pb = findViewById(R.id.pb)

        btn_register.setOnClickListener {
            register()
        }

        btn_google.setOnClickListener {
            dummy()
        }

    }

    private fun dummy() {
        edt_nama.setText("mikunitensai")
        edt_email.setText("mikunitensai@gmail.com")
        edt_password.setText("mikunitensai123")
        edt_phone.setText("08988509765")
        register()
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

        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(
            edt_nama.text.toString(), edt_email.text.toString(), edt_phone.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponModel>{
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon = response.body()!!
                if (respon.success === 1) {
                    pb.visibility = View.GONE
                    s.setStatusLogin(true)
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    Toast.makeText(this@RegisterActivity, "Selamat datang " + respon.user.name, Toast.LENGTH_SHORT).show()
                } else {
                    pb.visibility = View.GONE
                    Toast.makeText(this@RegisterActivity, "Register gagal", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@RegisterActivity, "Error: "+t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}