package com.kiran.student.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kiran.student.R
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.repository.UserRepository
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        CoroutineScope(Dispatchers.Main).launch {
            login()
            finish()
        }
    }

    private suspend fun login(){
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val password = sharedPref.getString("password", "")

        if (username != "" && password != "") {
            withContext(Dispatchers.IO) {
                try {
                    val repository = UserRepository()
                    val response = repository.checkUser(username!!, password!!)

                    if (response.success == true) {
                        ServiceBuilder.token = "Bearer ${response.token}"
                        startActivity(
                            Intent(
                                this@SplashActivity,
                                DashboardActivity::class.java
                            )
                        )
                    } else {
                        startActivity(
                            Intent(
                                this@SplashActivity,
                                LoginActivity::class.java
                            )
                        )
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@SplashActivity, ex.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }
        } else {
            startActivity(
                Intent(
                    this@SplashActivity,
                    LoginActivity::class.java
                )
            )
        }
    }
}