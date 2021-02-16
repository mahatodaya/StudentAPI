package com.kiran.student.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kiran.student.R
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter () : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
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


    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}