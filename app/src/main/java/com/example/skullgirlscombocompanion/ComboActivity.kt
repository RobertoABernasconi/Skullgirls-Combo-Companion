package com.example.skullgirlscombocompanion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
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

        val listener = View.OnClickListener { view ->
            when (view.id){
                R.id.descending_damage_sort_button -> DBManager.insertionSortDamage(character,"desc")
                R.id.ascending_damage_sort_button -> DBManager.insertionSortDamage(character,"asc")

                R.id.add_combo_to_database_button -> {
                    DBManager.addCombo(
                        character,
                        ComboModel(
                            character,
                            findViewById<EditText>(R.id.insert_damage_text).text.toString().toInt(),
                            findViewById<EditText>(R.id.insert_notation_text).text.toString()
                        )
                    )
                }
            }
        }

        findViewById<View>(R.id.descending_damage_sort_button).setOnClickListener(listener)
        findViewById<View>(R.id.ascending_damage_sort_button).setOnClickListener(listener)
        findViewById<View>(R.id.add_combo_to_database_button).setOnClickListener(listener)

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