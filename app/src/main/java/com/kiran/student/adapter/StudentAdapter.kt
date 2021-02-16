package com.kiran.student.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiran.student.R
import com.kiran.student.entity.Student
import com.kiran.student.repository.StudentRepository
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentAdapter (
    val lstStudents : MutableList<Student>,
    val context : Context

        ) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgProfile: CircleImageView = view.findViewById(R.id.imageProfile)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAge: TextView = view.findViewById(R.id.tvAge)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val tvGender: TextView = view.findViewById(R.id.tvGender)
        val btnEdit: ImageButton = view.findViewById(R.id.imgBtnEdit)
        val btnDelete: ImageButton = view.findViewById(R.id.imgBtnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.studentdetails_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudents[position]

        holder.tvName.text = student.fullname
        holder.tvAge.text = student.age.toString()
        holder.tvAddress.text = student.address
        holder.tvGender.text = student.gender

//        Glide.with(context)
//            .load(student.photo)
//            .into(holder.imgProfile)


//        holder.btnDelete.setOnClickListener {
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("Delete student")
//            builder.setMessage("Are you sure you want to delete ${student.fullname} ??")
//            builder.setIcon(android.R.drawable.ic_delete)
//            builder.setPositiveButton("Yes") { _, _ ->
//                CoroutineScope(Dispatchers.IO).launch {
//                    try {
//                        val studentRepository = StudentRepository()
//                        val response = studentRepository.deleteStudents(student._id!!)
//                        if (response.success == true) {
//                            withContext(Dispatchers.Main) {
//                                Toast.makeText(
//                                    context,
//                                    "Student Deleted",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                            withContext(Main) {
//                                lstStudents.remove(student)
//                                notifyDataSetChanged()
//                            }
//                        }
//                    } catch (ex: Exception) {
//                        withContext(Dispatchers.Main) {
//                            Toast.makeText(
//                                context,
//                                ex.toString(),
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//                }
//            }
//            builder.setNegativeButton("No") { _, _ ->
//            }
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//        }

    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}