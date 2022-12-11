package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.kodego.app.studentassistaneappv20.databinding.ActivitySubjectDetailsBinding

class SubjectDetails : AppCompatActivity() {

    lateinit var binding: ActivitySubjectDetailsBinding

    /**call id of the bottom navigation*/
    private lateinit var btnSubject: ImageButton
    private lateinit var btnAssignment: ImageButton
    private lateinit var btnNotes: ImageButton
    private lateinit var btnAnnouncement: ImageButton
    private lateinit var btnSyllabus: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //data from home activity for subject details xml
        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
        var imageSubject: Int = intent.getIntExtra("imageSubject",0)
////        var quantity: Int = intent.getIntExtra("quantity",0)

        //passing data to fragment 1 (subject frag)
        var bundleSubjectDetails = Bundle()
        bundleSubjectDetails.putString("subjectName", subjectName)

    }
}