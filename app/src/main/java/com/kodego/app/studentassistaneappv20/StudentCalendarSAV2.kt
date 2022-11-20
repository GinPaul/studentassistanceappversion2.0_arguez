package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import com.kodego.app.studentassistaneappv20.databinding.ActivityStudentCalendarSav2Binding
import java.util.*

class StudentCalendarSAV2 : AppCompatActivity() {

    lateinit var binding: ActivityStudentCalendarSav2Binding
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    val insertCalendarIntent = Intent(Intent.ACTION_INSERT)
        .setData(CalendarContract.Events.CONTENT_URI)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentCalendarSav2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAddSchedule.setOnClickListener() {
            Toast.makeText(applicationContext, "Opening event scheduler...", Toast.LENGTH_SHORT)
                .show()
            addCalendarEvent(binding.root)

        dateTV = binding.idTVDate
        calendarView = binding.calendarView

    }
}
    fun addCalendarEvent(view: View) {
        val calendarEvent: Calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("beginTime", calendarEvent.timeInMillis)
        intent.putExtra("allDay", true)
        intent.putExtra("rule", "FREQ=YEARLY")
        intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
        intent.putExtra("title", "Calendar Event")
        startActivity(intent)
    }
}