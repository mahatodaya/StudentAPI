package com.kiran.student.response

import com.kiran.student.entity.Student

class StudentResponse (
    val success: Boolean? = null,
    val data: MutableList<Student>? = null
        )