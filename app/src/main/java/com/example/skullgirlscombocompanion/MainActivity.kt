package com.example.skullgirlscombocompanion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listener = View.OnClickListener { view ->
            var intent = Intent(this@MainActivity, ComboActivity::class.java)
            intent.putExtra("character", view.contentDescription)
            startActivity(intent)
        }

        setContentView(R.layout.activity_main)

        val imageButton1 = findViewById<ImageButton>(R.id.imageButton1)
        imageButton1.setOnClickListener(listener)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        imageButton2.setOnClickListener(listener)
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        imageButton3.setOnClickListener(listener)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4)
        imageButton4.setOnClickListener(listener)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)
        imageButton5.setOnClickListener(listener)
        val imageButton6 = findViewById<ImageButton>(R.id.imageButton6)
        imageButton6.setOnClickListener(listener)
        val imageButton7 = findViewById<ImageButton>(R.id.imageButton7)
        imageButton7.setOnClickListener(listener)
        val imageButton8 = findViewById<ImageButton>(R.id.imageButton8)
        imageButton8.setOnClickListener(listener)
        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        imageButton9.setOnClickListener(listener)
        val imageButton10 = findViewById<ImageButton>(R.id.imageButton10)
        imageButton10.setOnClickListener(listener)
        val imageButton11 = findViewById<ImageButton>(R.id.imageButton11)
        imageButton11.setOnClickListener(listener)
        val imageButton12 = findViewById<ImageButton>(R.id.imageButton12)
        imageButton12.setOnClickListener(listener)
        val imageButton13 = findViewById<ImageButton>(R.id.imageButton13)
        imageButton13.setOnClickListener(listener)
        val imageButton14 = findViewById<ImageButton>(R.id.imageButton14)
        imageButton14.setOnClickListener(listener)
        val imageButton15 = findViewById<ImageButton>(R.id.imageButton15)
        imageButton15.setOnClickListener(listener)
        val imageButton16 = findViewById<ImageButton>(R.id.imageButton16)
        imageButton16.setOnClickListener(listener)
        val imageButton17 = findViewById<ImageButton>(R.id.imageButton17)
        imageButton17.setOnClickListener(listener)
    }

}