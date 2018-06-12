package com.example.poorwahirve.recyclerviewtest

import android.app.FragmentTransaction
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableError
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button : Button = findViewById(R.id.button)
//        button.setOnClickListener({v ->
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
//        })

        val myButtonObservable : Observable<Button> = Observable.create {
            button.setOnClickListener( {_ ->
                Toast.makeText(baseContext, "Button Clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(baseContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
        }
        myButtonObservable.subscribe()




    }
}
