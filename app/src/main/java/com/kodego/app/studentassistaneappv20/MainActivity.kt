package com.kodego.app.studentassistaneappv20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kodego.app.studentassistaneappv20.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var date: String
    lateinit var textView: TextView
    lateinit var button: Button
//    lateinit var adapter: SubjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        textView = findViewById(R.id.tvDateMain)
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("EEE | MMM dd, yyyy")
        date = simpleDateFormat.format(calendar.time)
        textView.text = date
    }
}