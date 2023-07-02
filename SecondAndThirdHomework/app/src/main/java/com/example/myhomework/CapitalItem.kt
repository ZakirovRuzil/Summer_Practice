package com.example.myhomework

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.myhomework.databinding.ItemCapitalBinding

class CapitalItem(
    private val binding: ItemCapitalBinding,
    private val glide:  RequestManager,
    private val onItemClick: (Capital) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(capital: Capital){
        binding.run{
            tvTittle.text = capital.name
            tvDesc.text = capital.description

            glide
                .load(capital.url)
                .placeholder(R.drawable.load)
                .error(R.drawable.images)
                .into(ivImage)

            root.setOnClickListener{
                onItemClick(capital)
            }
        }
    }
}