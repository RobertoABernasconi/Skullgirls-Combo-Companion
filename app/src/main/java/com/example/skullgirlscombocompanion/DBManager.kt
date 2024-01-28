package com.example.skullgirlscombocompanion

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

object DBManager {
    private val characters: List<String> = listOf(
        "Squigly",
        "Big Band",
        "Eliza",
        "Miss Fortune",
        "Peacock",
        "Painwheel",
        "Filia",
        "Cerebella",
        "Valentine",
        "Parasoul",
        "Double",
        "Fukua",
        "Beowulf",
        "Robo Fortune",
        "Umbrella",
        "Annie",
        "Black Dahlia"
    )

    @Volatile
    private var instance: DBManager? = null

    fun getInstance() =
        instance ?: synchronized(this) {
            instance ?: DBManager.also { instance = it }
        }

    private var combos = Firebase.firestore.collection("combo")

    var map = hashMapOf<String, ArrayList<ComboModel>>()


    fun setup() {
        for (character in characters) {
            if (!(map.contains(character))) {
                map[character] = arrayListOf()
            }
        }

        combos.get().addOnSuccessListener { result ->
            for (document in result) {
                val combo = ComboModel(document.get("character").toString(),  document.get("damage").toString().toInt(), document.get("input").toString().replace("\\n", "\n"))
                val character = combo.character
                map[character]?.add(combo)
            }

        }
            .addOnFailureListener { exception ->
                Log.d("DBManager", "Failed to fetch, may be end of elements")
            }

    }

    fun addCombo(character: String, combo: ComboModel) {
        map[character]!!.add(combo)

        combos.document().set(hashMapOf("character" to character, "damage" to combo.damage.toString(), "input" to combo.input))
    }

    fun listOfCombos(character: String): ArrayList<ComboModel>? {
        return map[character]
    }

    fun sortByDamage(character: String, mode: String) {
        map[character]!!.sortWith(ComboModel.sortByDamage(mode))
    }
    fun sortByStarter(character: String, mode: String) {
        map[character]!!.sortWith(ComboModel.sortByStarter(mode))
    }
}