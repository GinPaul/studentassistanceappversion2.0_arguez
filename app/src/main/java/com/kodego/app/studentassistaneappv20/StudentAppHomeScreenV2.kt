package com.kodego.app.studentassistaneappv20

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.kodego.app.studentassistaneappv20.databinding.ActivityStudentAppHomeScreenV2Binding
import java.text.SimpleDateFormat
import java.util.*

class StudentAppHomeScreenV2 : AppCompatActivity() {

    lateinit var binding : ActivityStudentAppHomeScreenV2Binding
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var date: String
    lateinit var textView: TextView
    lateinit var button: Button
//    lateinit var adapter: SubjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentAppHomeScreenV2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        /**Calendar*/
        binding.imgCalendarButton.setOnClickListener() {
            Toast.makeText(applicationContext, "Opening calendar...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, StudentCalendarSAV2::class.java)
            startActivity(intent)
        }

        //showing current date and time
        textView = binding.tvDateToday
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("EEE | MMM dd, yyyy")
        date = simpleDateFormat.format(calendar.time)
        textView.text = date

        /**for dialog*/
//        binding.btnCustomDialog.setOnClickListener(){
//            showCustomDialog()
//        }

//        binding.btnBuiltIn.setOnClickListener(){
//            showBuiltInDialog()
//        }

        /**for camera*/
        binding.imgProfileEdit.setOnClickListener(){
//            showCamera()
            AlertDialog.Builder( this).setMessage("Which data source?")
                .setPositiveButton("Camera"){dialog, item ->
                    showCamera()
                    binding.imgProfileEdit.setImageResource(R.drawable.ic_baseline_edit_24)
                }.setNegativeButton("Gallery"){dialog, item ->
                    showGallery()
                    binding.imgProfileEdit.setImageResource(R.drawable.ic_baseline_edit_24)
                }.show()
        }

        /**getting image from the internet into the profile image*/
//        Glide.with(this)
//            .load(imageKodego)
////            .override(100,200) //to override the size of the image
////            .circleCrop() //to circle crop the image
//            .into(binding.profileImage)

        /**getting image from the gallery*/
//        binding.btnGallery.setOnClickListener(){
//            showGallery() //<< create a function showGallery
//        }

    }
    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object: PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission approved!", Toast.LENGTH_SHORT).show()
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                startActivity(cameraIntent) << this is just to open the camera but no next step
                cameraLauncher.launch(cameraIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission denied!", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }
        }).onSameThread().check() //<<don't forget this!
    }

    //help the user go to Settings
    private fun gotoSettings() {
        AlertDialog.Builder( this).setMessage("Camera Permission is denied. Please go to Settings to enable camera permission.")
            .setPositiveButton("Go to Settings"){dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel"){dialog, item ->
                dialog.dismiss()
            }.show()
    }

    private fun showGallery(){
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object: PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission granted!", Toast.LENGTH_SHORT).show()
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                galleryLauncher.launch(galleryIntent)
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Permission denied!", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check() //<<don't forget this!
    }

    //handles images from camera
    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            result.data?.extras.let{
                val image: Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.profileImage.setImageBitmap(image)
            }
        }
    }

    //handles images from the gallery
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let{
                val selectedImage = result.data?.data
                binding.profileImage.setImageURI(selectedImage)
            }
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

//        fun addCalendarEvent(view: View) {
//            val calendarEvent: Calendar = Calendar.getInstance()
//            val intent = Intent(Intent.ACTION_EDIT)
//            intent.type = "vnd.android.cursor.item/event"
//            intent.putExtra("beginTime", calendarEvent.timeInMillis)
//            intent.putExtra("allDay", true)
//            intent.putExtra("rule", "FREQ=YEARLY")
//            intent.putExtra("endTime", calendarEvent.timeInMillis + 60 * 60 * 1000)
//            intent.putExtra("title", "Calendar Event")
//            startActivity(intent)
    }

}

