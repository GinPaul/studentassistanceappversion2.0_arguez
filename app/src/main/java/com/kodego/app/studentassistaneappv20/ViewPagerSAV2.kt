package com.kodego.app.studentassistaneappv20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.kodego.app.studentassistaneappv20.databinding.ActivityViewPagerSav2Binding

class ViewPagerSAV2 : AppCompatActivity() {

    lateinit var binding: ActivityViewPagerSav2Binding

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlideforViewPager(
                "Manage your Account",
                "",
                R.drawable.studentprofile
            ),
            IntroSlideforViewPager(
                "View your Schedule",
                "",
                R.drawable.studentschedule
            ),
            IntroSlideforViewPager(
                "Be up to date with Announcements",
                "",
                R.drawable.megaphonepink
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerSav2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //DON'T FORGET THE BINDING. !!! :-)
        binding.introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        binding.introSliderViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        binding.buttonNext.setOnClickListener  {
            if (binding.introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount){
                binding.introSliderViewPager.currentItem  += 1
            }else{
                Intent(applicationContext, LoginPageStudentAppV2::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
        binding.textSkipIntro.setOnClickListener{
            Intent(applicationContext, LoginPageStudentAppV2::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0,0,0,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorsContainer.addView(indicators[i])
        }
    }
    private fun setCurrentIndicator(index: Int){
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = binding.indicatorsContainer[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
