package com.example.addtaskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addtaskapp.adapter.taskadapter
import com.example.addtaskapp.model.Taskmodel

class MainActivity : AppCompatActivity() {

    private var myAdapter : taskadapter = taskadapter(this, mutableListOf())
    private var recycView = 0

    companion object{
        const val TAG = "MainActivity"
        const val KEY_RECYCVIEW = "key_recycview"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "OnCreate called")
        if(savedInstanceState != null){
            recycView = savedInstanceState.getInt(KEY_RECYCVIEW, 0)
        }

        setContentView(R.layout.activity_main)

        val editField : TextView = findViewById(R.id.edit_text)
        val addIcon : View = findViewById(R.id.icon)
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)


        addIcon.setOnClickListener {
            val newTaskTitle = editField.text.toString()
            if(newTaskTitle.isNotEmpty()){
                val newtask = Taskmodel(newTaskTitle)
                myAdapter.addTask(newtask)
                editField.text = " "
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d( TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d( TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d( TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d( TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( TAG, "onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( TAG, "onRestart Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_RECYCVIEW, recycView)
        Log.d( TAG, "onSaveInstance Called")
    }
}