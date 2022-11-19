package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenV2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_v2)

        CoroutineScope(Dispatchers.Main).launch {
            delay(3500L)
            startActivity(Intent(this@SplashScreenV2, ViewPagerSAV2::class.java))
            finish()
        }
    }
}