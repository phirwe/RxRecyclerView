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
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_blank.*
import java.util.*

class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val fragmentBlank = inflater?.inflate(R.layout.fragment_blank, container, false)
        var clickMe : Button = fragmentBlank!!.findViewById(R.id.clickMe)
        var fragmentText : TextView = fragmentBlank!!.findViewById(R.id.fragmentText)

        val myTextObservable : Observable<TextView> = Observable
                .just(fragmentText)
                .doOnNext {
                    val myStringMap : Array<String> = resources.getStringArray(R.array.my_dataset_mapped)
                    val myStringMapped : String = myStringMap[arguments.getInt("main")]
                    it.text = myStringMapped
                }

        myTextObservable.subscribe()

        val myButtonObservable : Observable<Button> = Observable
                .just(clickMe)
                .doOnNext {
                    it.setOnClickListener {
                        val intent = Intent(activity.applicationContext, Main2Activity::class.java)
                        startActivity(intent)
                    }
                }

        myButtonObservable.subscribe()

        return fragmentBlank

    }



}