package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.kodego.app.studentassistaneappv20.databinding.ActivitySubjectDetailsBinding

class SubjectDetails : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsBinding

    /**call id of the bottom navigation*/
    private lateinit var btnSubject: ImageButton
    private lateinit var btnAssignment: ImageButton
    private lateinit var btnNotes: ImageButton
    private lateinit var btnAnnouncement: ImageButton
    private lateinit var btnSyllabus: ImageButton

    private lateinit var manger: FragmentTransaction
    private val fragmentManger = supportFragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //data from home activity for subject details xml
        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
        var imageSubject: Int = intent.getIntExtra("imageSubject",0)
////        var quantity: Int = intent.getIntExtra("quantity",0)

        //passing data to subject details
        var bundleSubjectDetails = Bundle()
        bundleSubjectDetails.putString("subjectName", subjectName)


        //transferring to Assignments
        binding.assignments.setOnClickListener() {
            Toast.makeText(applicationContext, "Showing Assignments...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Assignments::class.java)
            startActivity(intent)
        }

    }

}