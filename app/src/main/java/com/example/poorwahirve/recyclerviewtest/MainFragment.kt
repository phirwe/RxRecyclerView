package com.example.poorwahirve.recyclerviewtest

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_blank.*

class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val fragmentBlank = inflater?.inflate(R.layout.fragment_blank, container, false)
        var clickMe : Button = fragmentBlank!!.findViewById(R.id.clickMe)
        var fragmentText : TextView = fragmentBlank!!.findViewById(R.id.fragmentText)

        fragmentText.text = arguments.getString("main")

        clickMe.setOnClickListener({ _ ->
            val intent = Intent(activity.applicationContext, Main2Activity::class.java)
            startActivity(intent)
        })

        return fragmentBlank

    }



}