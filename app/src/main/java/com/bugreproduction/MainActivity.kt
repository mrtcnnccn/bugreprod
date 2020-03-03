package com.bugreproduction

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bugreproduction.geftimov.GeftimovTransformerBugActivity

class MainActivity : AppCompatActivity() {
    private lateinit var geftimov: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }

        geftimov = findViewById(R.id.geftimov)

        geftimov.setOnClickListener {
            startActivity(Intent(this, GeftimovTransformerBugActivity::class.java))
        }
    }
}
