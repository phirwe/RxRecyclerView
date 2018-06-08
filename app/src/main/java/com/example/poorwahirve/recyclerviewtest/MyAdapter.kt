package com.example.poorwahirve.recyclerviewtest

import android.content.Context
import android.content.Intent
import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import io.reactivex.*

class MyAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) // shows that the recycler view is essentially a ListView of texts

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create new view
        // set view settings
        // add to RecyclerView

        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_text_view, parent, false) as TextView
        return ViewHolder(textView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = myDataset[position]
        holder.textView.setOnClickListener({v: View? ->
            val context : Context = v!!.context
            //Toast.makeText(context, "Hello: " + position.toString(), Toast.LENGTH_SHORT).show()
            //val intent = Intent(context, Main2Activity::class.java)
            //context.startActivity(intent)
            val bundle = Bundle()
            bundle.putString("main", myDataset[position])
            val fragment = MainFragment()
            fragment.arguments = bundle
            val fragmentTransaction : FragmentTransaction = (context as FragmentActivity).fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.trial2, fragment).commit()
        })
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }


}