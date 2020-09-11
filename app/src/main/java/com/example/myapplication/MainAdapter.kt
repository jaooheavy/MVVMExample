package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.POJO.Character
import kotlinx.android.synthetic.main.list_character.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.VH>() {

    private val items = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.list_character, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.tvTitle.text = items[position].name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(characters: List<Character>){
        items.clear()
        items.addAll(characters)
        notifyDataSetChanged()
    }

    class VH(itemView:View): RecyclerView.ViewHolder(itemView){}
}