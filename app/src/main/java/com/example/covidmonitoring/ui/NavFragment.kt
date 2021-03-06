package com.example.covidmonitoring.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covidmonitoring.R
import kotlinx.android.synthetic.main.fragment_navigation.*

class NavFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnGlobalData.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, GlobalFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        btnRussionData.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, GlobalFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}