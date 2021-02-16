package com.kiran.student.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.kiran.student.R
import com.kiran.student.api.ServiceBuilder

class DashboardActivity : AppCompatActivity() {
    private lateinit var btnAddStudent : Button
    private lateinit var btnViewStudent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnAddStudent = findViewById(R.id.btnStudentAdd)
        btnViewStudent = findViewById(R.id.btnViewStudent)

        Toast.makeText(this, ServiceBuilder.token, Toast.LENGTH_LONG).show()

        btnAddStudent.setOnClickListener { startActivity(Intent(this, AddStudentsActivity::class.java)) }
        btnViewStudent.setOnClickListener { startActivity(Intent(this, StudentDetailsActivity::class.java)) }

    }
}