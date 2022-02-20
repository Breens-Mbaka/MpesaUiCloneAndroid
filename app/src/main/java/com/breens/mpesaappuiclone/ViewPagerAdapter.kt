package com.breens.mpesaappuiclone

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip

class ViewPagerAdapter(private var title: List<String>,private var titleTwo: List<String>, private var titleThree: List<String>, private var titleFour: List<String>, private var icon: List<Int>, private var background: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.spent_this_week_label)
        val itemTitleTwo : TextView = itemView.findViewById(R.id.weekly_amount)
        val itemTitleThree: TextView = itemView.findViewById(R.id.textView4)
        val itemTitleFour: TextView = itemView.findViewById(R.id.textView3)
        val icon: ImageView = itemView.findViewById(R.id.mpesaloading)
        val background: ConstraintLayout = itemView.findViewById(R.id.container)
        init {
            icon.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemTitleTwo.text = titleTwo[position]
        holder.itemTitleThree.text = titleThree[position]
        holder.itemTitleFour.text = titleFour[position]
        holder.icon.setImageResource(icon[position])
        holder.background.setBackgroundResource(background[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }

}