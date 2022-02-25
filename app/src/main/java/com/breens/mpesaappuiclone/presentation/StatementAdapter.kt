package com.breens.mpesaappuiclone.presentation


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.breens.mpesaappuiclone.R
import com.breens.mpesaappuiclone.data.Statement
import io.getstream.avatarview.AvatarView

class StatementAdapter(private val mList: List<Statement>) : RecyclerView.Adapter<StatementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_statement, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val statement = mList[position]

        holder.initials.avatarInitials = statement.initials
        holder.shopName.text = statement.shopName
        holder.transactionId.text = statement.transactionId
        holder.amount.text = statement.amount
        holder.transactionDate.text = statement.transactionDate
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val initials: AvatarView = itemView.findViewById(R.id.avatarView)
        val shopName: TextView = itemView.findViewById(R.id.shop)
        val transactionId: TextView = itemView.findViewById(R.id.id)
        val amount: TextView = itemView.findViewById(R.id.amount)
        val transactionDate: TextView = itemView.findViewById(R.id.date)
    }
}


