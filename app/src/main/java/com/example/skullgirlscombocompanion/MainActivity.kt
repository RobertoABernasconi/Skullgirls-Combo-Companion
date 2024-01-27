package com.example.skullgirlscombocompanion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.ComponentActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DBManager.setup()

        val listener = View.OnClickListener { view ->

            var intent = Intent(this@MainActivity, ComboActivity::class.java)
            intent.putExtra("character", view.contentDescription) //identifies the character to fetch

            startActivity(intent)
        }

        setContentView(R.layout.activity_main)

        //setting the OnClickListener for each imageButton
        findViewById<ImageButton>(R.id.imageButton1).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton2).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton3).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton4).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton5).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton6).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton7).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton8).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton9).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton10).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton11).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton12).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton13).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton14).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton15).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton16).setOnClickListener(listener)
        findViewById<ImageButton>(R.id.imageButton17).setOnClickListener(listener)
    }
}

