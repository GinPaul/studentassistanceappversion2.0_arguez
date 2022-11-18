package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.app.studentassistaneappv20.databinding.ActivityLoginPageStudentAppV2Binding

class LoginPageStudentAppV2 : AppCompatActivity() {

    lateinit var binding: ActivityLoginPageStudentAppV2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageStudentAppV2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //login
        binding.btnLoginv2.setOnClickListener(){
            var userName: String = binding.etUserNamev2.text.toString()
            var password: String = binding.etPasswordv2.text.toString()
            checkCredential(userName, password)

    }
}
    private fun checkCredential(userName: String, password: String): Boolean {
        val correctUserName: String = "admin"
        val correctPassword: String = "admin123"

        val correctUserName2: String = "Paul_A."
        val correctPassword2: String = "pass123"

        if((correctUserName == userName) && (correctPassword == password)){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true
        }else if((correctUserName2 == userName) && (correctPassword2 == password)) {
            val intent = Intent(this, StudentAppHomeScreenV2::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(applicationContext, "Invalid Credentials. Try again.", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}