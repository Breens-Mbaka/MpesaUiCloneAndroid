package com.breens.mpesaappuiclone.presentation.interface_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.breens.mpesaappuiclone.data.model.CardInfo
import com.breens.mpesaappuiclone.databinding.ItemCardviewBinding

class ViewPagerAdapter(private var title: List<String>,private var titleTwo: List<String>, private var titleThree: List<String>, private var titleFour: List<String>, private var icon: List<Int>, private var background: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(val binding:ItemCardviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int){
            binding.apply {
                val cardInformation = CardInfo(
                    mainTitle = title[position],
                    mainAmount = titleTwo[position],
                    subTitle = titleFour[position],
                    subAmount = titleThree[position],
                    icon = icon[position],
                    background = background[position]
                )
                cardInfo = cardInformation

            }
        }

        init {
            binding.mpesaloading.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardviewBinding.inflate(inflater, parent, false)
        return Pager2ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return title.size
    }

}