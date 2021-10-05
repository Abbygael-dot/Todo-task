package com.example.addtaskapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addtaskapp.R
import com.example.addtaskapp.adapter.taskadapter
import com.example.addtaskapp.databinding.FragmentAddTaskBinding
import com.example.addtaskapp.databinding.FragmentSignUpBinding
import com.example.addtaskapp.model.Taskmodel


class AddTaskFragment : Fragment() {

    private var _binding: FragmentAddTaskBinding? = null
    private val binding get() = _binding!!
    private lateinit var name: String
    private var myAdapter: taskadapter = taskadapter(this, mutableListOf())
//    private var myAdapter : taskadapter = taskadapter(this, mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            name = it.getString("name").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddTaskBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcome.text = getString(R.string.welcome_abby,name)
//        binding.welcome.text= name
        binding.recyclerViewTask.adapter = myAdapter
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())

        binding.icon.setOnClickListener {
            val newTaskTitle = binding.editText.text.toString()
            if (newTaskTitle.isNotEmpty()){
                val newTask = Taskmodel(newTaskTitle)
                myAdapter.addTask(newTask)
                binding.editText.text = null
            }
        }
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.fragment_add_task)


//        val editField : TextView = findViewById(R.id.edit_text)
//        val addIcon : View = findViewById(R.id.icon)
//        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)

//        recyclerview.adapter = myAdapter
//        recyclerview.layoutManager = LinearLayoutManager(this)

//
//        addIcon.setOnClickListener {
//            val newTaskTitle = editField.text.toString()
//            if(newTaskTitle.isNotEmpty()){
//                val newtask = Taskmodel(newTaskTitle)
//                myAdapter.addTask(newtask)
//                editField.text = " "
//            }
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d( TAG, "onStart Called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d( TAG, "onResume Called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d( TAG, "onPause Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d( TAG, "onStop Called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d( TAG, "onDestroy Called")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d( TAG, "onRestart Called")
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt(KEY_RECYCVIEW, recycView)
//        Log.d( TAG, "onSaveInstance Called")

//    private var _binding : FragmentAddTaskBinding? = null
//    private val  binding get() = _binding
//    private lateinit var recyclerView : RecyclerView
//


}



//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add_task, container, false)
//    }

