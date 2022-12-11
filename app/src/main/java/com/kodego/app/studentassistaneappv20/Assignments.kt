package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.app.studentassistaneappv20.databinding.ActivityAssignmentsBinding

class Assignments : AppCompatActivity() {

    lateinit var binding: ActivityAssignmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAssignmentsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //to return to subject details
        binding.subjectDetails.setOnClickListener() {
            Toast.makeText(applicationContext, "Showing Subject Details...", Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(this, SubjectDetails::class.java)
            startActivity(intent)
        }
    }
}