package com.mikunitensai.newsia.activity

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
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var btn_login:Button
    lateinit var edt_email: EditText
    lateinit var edt_password: EditText
    lateinit var pb: ProgressBar
    lateinit var btn_lupaPassword: TextView

    lateinit var s:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.btn_login)
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)
        btn_lupaPassword = findViewById(R.id.btn_lupaPassword)

        pb = findViewById(R.id.pb)

        s = SharedPreferences(this)

        btn_login.setOnClickListener {
            login()
        }

        btn_lupaPassword.setOnClickListener {
            dummy()
        }
    }

    private fun dummy() {
        edt_email.setText("mikunitensai@gmail.com")
        edt_password.setText("mikunitensai123")
        login()
    }

    private fun login() {
        if (edt_email.text.isEmpty()){
            edt_email.error = "Kolom email kosong"
            edt_email.requestFocus()
            return
        } else if (edt_password.text.isEmpty()){
            edt_password.error = "Kolom password kosong"
            edt_password.requestFocus()
            return
        }

        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.login(
            edt_email.text.toString(),
            edt_password.text.toString()).enqueue(object : Callback<ResponModel> {
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon = response.body()!!
                if (respon.Success == 1) {
                    pb.visibility = View.VISIBLE
                    s.setStatusLogin(true)
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@LoginActivity, "Login berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    pb.visibility = View.VISIBLE
                    Toast.makeText(this@LoginActivity, "Login gagal", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error: "+t.message, Toast.LENGTH_SHORT).show()
                pb.visibility = View.VISIBLE
            }
        })
    }
}