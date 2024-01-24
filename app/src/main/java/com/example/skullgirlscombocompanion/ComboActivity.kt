package com.example.skullgirlscombocompanion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

class ComboActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val character: String? = intent.getStringExtra("character")

        setContentView(R.layout.activity_combo_view)
        Toast.makeText(this, character, Toast.LENGTH_SHORT).show()
    }
}