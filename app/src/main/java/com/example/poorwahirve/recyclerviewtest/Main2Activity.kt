package com.example.poorwahirve.recyclerviewtest

import android.app.FragmentTransaction
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener({v ->
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        })


    }
}
