package com.example.skullgirlscombocompanion

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ComboActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val character: String = intent.getStringExtra("character")!!
        val comboList: ArrayList<ComboModel>? = DBManager.getInstance().listOfCombos(character)
        var starterMode = "Asc"
        var damageMode = "Asc"

        setContentView(R.layout.activity_combo_view)

        val recyclerView = findViewById<RecyclerView>(R.id.ComboRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ComboListAdapter(comboList!!)
        recyclerView.adapter = adapter

        val listener = View.OnClickListener { view ->
            when (view.id){
                R.id.starter_sort_button -> {
                    DBManager.sortByDamage(character, starterMode)
                    adapter.notifyDataSetChanged() //may be a better way

                    starterMode = if (starterMode == "Asc") {"Desc"} else {"Asc"}
                }
                R.id.damage_sort_button -> {
                    DBManager.sortByStarter(character, damageMode)
                    adapter.notifyDataSetChanged() //may be a better way

                    damageMode = if (damageMode == "Asc") {"Desc"} else {"Asc"}
                }
                R.id.add_combo_to_database_button -> {

                    try {
                        val damage = findViewById<EditText>(R.id.insert_damage_text).text.toString().toInt()
                        if(damage in 1..40000) {
                            DBManager.addCombo(
                                character,
                                ComboModel(
                                    character,
                                    damage,
                                    findViewById<EditText>(R.id.insert_notation_text).text.toString()
                                )
                            )
                            findViewById<EditText>(R.id.insert_damage_text).setText("")
                            findViewById<EditText>(R.id.insert_notation_text).setText("")
                        } else {
                            Toast.makeText(this, "Couldn't add to DB, damage is not a valid number", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this, "Couldn't add to DB, damage is not a number", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        findViewById<View>(R.id.starter_sort_button).setOnClickListener(listener)
        findViewById<View>(R.id.damage_sort_button).setOnClickListener(listener)
        findViewById<View>(R.id.add_combo_to_database_button).setOnClickListener(listener)

        Toast.makeText(this, character, Toast.LENGTH_SHORT).show()
    }
}