package com.kiran.student.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.kiran.student.R
import com.kiran.student.entity.Student
import com.kiran.student.repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.Inet4Address

class AddStudentsActivity : AppCompatActivity() {
    private lateinit var imgStudentProfile: ImageView
    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var rdoGender: RadioGroup
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_students)

        imgStudentProfile = findViewById(R.id.imgStudentProfile)
        etFullName = findViewById(R.id.etFullName)
        etAge = findViewById(R.id.etAge)
        rdoMale = findViewById(R.id.rdoMale)
        rdoFemale = findViewById(R.id.rdoFemale)
        rdoOthers = findViewById(R.id.rdoOthers)
        etAddress = findViewById(R.id.etAddress)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            saveStudent()
        }
    }

    private fun saveStudent() {
        val fullName = etFullName.text.toString()
        val age = etAge.text.toString().toInt()
        val address = etAddress.text.toString()
        var gender = ""
        when {
            rdoFemale.isChecked -> {
                gender = "Female"
            }
            rdoMale.isChecked -> {
                gender = "Male"
            }
            rdoOthers.isChecked -> {
                gender = "Others"
            }
        }
        val student =
            Student(fullname = fullName, age = age,
                gender = gender, address = address)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val studentRepository = StudentRepository()
                val response = studentRepository.insertStudent(student)
                if (response.success == true) {
                    withContext(Main) {
                        Toast.makeText(
                            this@AddStudentsActivity,
                            "Student Added",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@AddStudentsActivity,
                        ex.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}