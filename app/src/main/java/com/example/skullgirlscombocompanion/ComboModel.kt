package com.example.skullgirlscombocompanion

class ComboModel(val character: String?, val damage: Int, val input: String) {
    companion object{
        fun sortByDamage(mode: String?): Comparator<ComboModel> = object : Comparator<ComboModel>{
            override fun compare(p0: ComboModel?, p1: ComboModel?): Int {
                if(mode == "Asc"){
                    return p0!!.damage.compareTo(p1!!.damage)
                }
                return p1!!.damage.compareTo(p0!!.damage)
            }
        }

        fun sortByStarter(mode: String?): Comparator<ComboModel> = object : Comparator<ComboModel>{
            override fun compare(p0: ComboModel?, p1: ComboModel?): Int {
                if(mode == "Asc"){
                    return p0!!.input.compareTo(p1!!.input)
                }
                return p1!!.input.compareTo(p0!!.input)
            }
        }
    }
}