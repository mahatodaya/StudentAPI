package com.kiran.student.api

import com.kiran.student.entity.Student
import com.kiran.student.response.AddStudentResponse
import com.kiran.student.response.DeleteStudentResponse
import com.kiran.student.response.StudentResponse
import retrofit2.Response
import retrofit2.http.*

interface StudentAPI {
    @POST("student/")
    suspend fun insertStudent(
        @Header("Authorization") token: String,
        @Body student: Student
    ) : Response<AddStudentResponse>

    @GET("student/")
    suspend fun getAllStudents(
        @Header("Authorization") token: String
    ) : Response<StudentResponse>

    @DELETE("student/{id}")
    suspend fun deleteStudent(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<DeleteStudentResponse>
}