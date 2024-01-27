package com.example.skullgirlscombocompanion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComboListAdapter(private val list: ArrayList<ComboModel>) : RecyclerView.Adapter<ComboListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.combo_card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comboModel = list[position]
        holder.notationTextView.text = comboModel.input
        holder.damageTextView.text = ("Damage:\n" + comboModel.damage.toString())

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val notationTextView: TextView = itemView.findViewById(R.id.combonotationview)
        val damageTextView: TextView = itemView.findViewById(R.id.combodamageview)
    }
}