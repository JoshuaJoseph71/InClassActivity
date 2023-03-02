package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        val spinner = findViewById<Spinner>(R.id.spinner)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Fetch images into Array<Int> called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = Array(typedArray.length()) { typedArray.getResourceId(it, 0) }
        typedArray.recycle()

        // Display images specified in imageArray in Spinner and RecyclerView

        findViewById<Spinner>(R.id.spinner)?.apply {
            adapter = CustomSpinnerAdapter(this@MainActivity, imageArray)
        }

        findViewById<RecyclerView>(R.id.recyclerView)?.apply {
            adapter = CustomRecyclerAdapter(imageArray)
            layoutManager = LinearLayoutManager(this@MainActivity)

        }


    }
}