package com.kiran.student.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiran.student.R
import com.kiran.student.adapter.StudentAdapter
import com.kiran.student.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        recyclerView = findViewById(R.id.recyclerView)

        loadStudents()
    }

    private fun loadStudents() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = StudentRepository().getAllStudents()
                if(response.success==true){
                    // Put all the student details in lstStudents
                    withContext(Main){
                        recyclerView.adapter = StudentAdapter(response.data!!,this@StudentDetailsActivity)
                        recyclerView.layoutManager = LinearLayoutManager(this@StudentDetailsActivity)
                    }
                }
            }catch(ex : Exception){
                withContext(Main){
                    Toast.makeText(this@StudentDetailsActivity,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}