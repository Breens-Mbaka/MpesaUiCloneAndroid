package com.breens.mpesaappuiclone.presentation


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.breens.mpesaappuiclone.R
import com.breens.mpesaappuiclone.data.model.Statement
import com.breens.mpesaappuiclone.databinding.ItemStatementBinding
import io.getstream.avatarview.AvatarView

class StatementAdapter(private val mList: List<Statement>) : RecyclerView.Adapter<StatementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStatementBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding:ItemStatementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mStatement: Statement){
            binding.statement = mStatement
        }
    }
}


