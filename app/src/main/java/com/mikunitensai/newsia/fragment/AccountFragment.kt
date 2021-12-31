package com.mikunitensai.newsia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mikunitensai.newsia.R
import com.mikunitensai.newsia.helper.SharedPreferences

class AccountFragment : Fragment() {

    lateinit var s: SharedPreferences
    lateinit var buttonProsesLogout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_account, container, false)
        buttonProsesLogout = view.findViewById(R.id.btnProsesLogout)

        s = SharedPreferences(requireActivity())

        buttonProsesLogout.setOnClickListener {
            s.setStatusLogin(false)
        }

        return view
    }

}