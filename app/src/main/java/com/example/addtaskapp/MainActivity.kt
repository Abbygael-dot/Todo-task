package com.example.addtaskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addtaskapp.adapter.taskadapter
import com.example.addtaskapp.databinding.ActivityMainBinding
import com.example.addtaskapp.model.Taskmodel

class MainActivity : AppCompatActivity() {

//    private var myAdapter : taskadapter = taskadapter(this, mutableListOf())
//    private var recycView = 0
//
//    companion object{
//        const val TAG = "MainActivity"
//        const val KEY_RECYCVIEW = "key_recycview"

    private lateinit var navCon:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        navCon = navHost.navController
        setupActionBarWithNavController(navCon)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navCon.navigateUp() || super.onSupportNavigateUp()
    }

}