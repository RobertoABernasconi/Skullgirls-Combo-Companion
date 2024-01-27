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
    }

    fun listOfCombos(character: String): ArrayList<ComboModel>? {
        return map[character]
    }

    //simple insertion sort as there should be few elements
    fun insertionSortDamage(character: String, mode: String) {
        var tempArray: ArrayList<ComboModel> = map[character]!!
        val n = tempArray.size

        for (i in 1 until n) {
            val key = tempArray[i]
            val keyDamage = key.damage
            var j = i - 1
            while ((j >= 0) && (tempArray[j].damage > keyDamage)) {
                tempArray[j + 1] = tempArray[j]
                j--
            }
            tempArray[j + 1] = key
        }

        //invert order if descending
        if (mode == "Desc") {
            for (i in 0 until n / 2) {
                val temp = tempArray[i]
                tempArray[i] = tempArray[n - i]
                tempArray[n - i] = temp
            }
        }

        map[character] = tempArray
    }
}