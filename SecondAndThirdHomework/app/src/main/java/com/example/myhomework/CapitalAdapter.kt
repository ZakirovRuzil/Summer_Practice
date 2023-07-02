package com.example.myhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myhomework.databinding.ItemCapitalBinding

class CapitalAdapter(
    private val list: List<Capital>,
    private val glide: RequestManager,
    private val onItemClick: (Capital) -> Unit,
) : RecyclerView.Adapter<CapitalItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): CapitalItem = CapitalItem(
        binding = ItemCapitalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide,
        onItemClick = onItemClick,
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CapitalItem, position: Int) {
        holder.onBind(list[position])
    }
}