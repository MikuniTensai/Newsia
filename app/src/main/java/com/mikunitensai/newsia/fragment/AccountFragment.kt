package com.mikunitensai.newsia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.helper.SharedPreferences

class AccountFragment : Fragment() {

    lateinit var s: SharedPreferences
    lateinit var buttonProsesLogout: TextView
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_account, container, false)

        initComponents(view)

        s = SharedPreferences(requireActivity())

        buttonProsesLogout.setOnClickListener {
            s.setStatusLogin(false)
        }

        setData()
        return view
    }

    fun setData(){
        tvNama.text = s.getString(s.nama)
        tvEmail.text = s.getString(s.email)
        tvPhone.text = s.getString(s.phone)

    }

    private fun initComponents(view: View) {
        buttonProsesLogout = view.findViewById(R.id.btnProsesLogout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
    }

}