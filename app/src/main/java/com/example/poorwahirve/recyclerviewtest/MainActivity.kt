package com.example.poorwahirve.recyclerviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.poorwahirve.recyclerviewtest.R.styleable.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager
    private lateinit var myDataset : Array<String>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDataset = resources.getStringArray(R.array.my_dataset)
        viewManager = LinearLayoutManager(this)
        observableAdapter(myDataset)

        recyclerView = my_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
    fun observableAdapter(myDataset : Array<String>) {
        val myDatasetObservable : Observable<Array<String>> = Observable.just(myDataset)
        myDatasetObservable
                .subscribe { viewAdapter = MyAdapter(myDataset) }
    }
}
