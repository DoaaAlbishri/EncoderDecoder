package com.example.encoderdecoder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encoderdecoder.databinding.ItemRowBinding


class RVAdapter(private var phrases: ArrayList<ArrayList<String>>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val phrase = phrases[position]

        holder.binding.apply {
            tvWord.text = phrase[0]
            tvEdit.text = phrase[1]
        }
    }

    override fun getItemCount() = phrases.size

    fun update(){
        notifyDataSetChanged()
    }
}