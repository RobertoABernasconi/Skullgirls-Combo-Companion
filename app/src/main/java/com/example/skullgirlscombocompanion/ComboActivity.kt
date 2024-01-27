package com.example.skullgirlscombocompanion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ComboActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val character: String = intent.getStringExtra("character")!!
        var comboList: ArrayList<ComboModel>? = DBManager.getInstance().listOfCombos(character)
        setContentView(R.layout.activity_combo_view)
        val recyclerView = findViewById<RecyclerView>(R.id.ComboRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ComboListAdapter(comboList!!)
        recyclerView.adapter = adapter


        Toast.makeText(this, character, Toast.LENGTH_SHORT).show()
    }


    /* test
    private fun getCombos(): ArrayList<ComboModel> {
        //create a List and add all elements from the DB
        var list: ArrayList<ComboModel> = arrayListOf()
        val combo1 = ComboModel(intent.getStringExtra("character"),"abc\ndef\nghi\njkl", 8203)
        val combo2 = ComboModel(intent.getStringExtra("character"),"abc\ndef\nghi\njkl", 8203)
        list.add(combo1)
        list.add(combo2)
        return list
    }
    */
}