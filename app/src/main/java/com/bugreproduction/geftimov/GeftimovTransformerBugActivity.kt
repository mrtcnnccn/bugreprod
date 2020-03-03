package com.bugreproduction.geftimov

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.bugreproduction.R
import com.eftimoff.viewpagertransformers.CubeOutTransformer

class GeftimovTransformerBugActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var adapterGeftimov: GeftimovTabAdapter
    private val geftimovVM: GeftimovViewModel by viewModels()


    private var indexCurrent: Int = 3
    private val size: Int = 10
    private val offscreenPageLimit = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geftimov_transformer_bug)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }

        viewPager = findViewById(R.id.view_pager)

        adapterGeftimov =
            GeftimovTabAdapter(supportFragmentManager, size)

        viewPager.adapter = adapterGeftimov
        viewPager.setPageTransformer(true, CubeOutTransformer())

        viewPager.offscreenPageLimit = offscreenPageLimit
        viewPager.currentItem = indexCurrent

        geftimovVM.changePageEvent.observe(this, Observer {
            if(it >= size){
                finish()
            }
            viewPager.setCurrentItem(it, true)
        })
    }
}