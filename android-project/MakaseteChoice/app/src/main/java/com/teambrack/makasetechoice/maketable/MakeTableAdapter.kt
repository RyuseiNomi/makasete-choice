package com.teambrack.makasetechoice.maketable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.MemberItemBinding

class MakeTableAdapter(
    private val viewModel: MakeTableViewModel
) : RecyclerView.Adapter<MakeTableAdapter.MakeTableViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeTableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.member_item, parent, false)

        return MakeTableViewHolder(view)
    }

    override fun getItemCount() = viewModel.members.size

    override fun onBindViewHolder(holder: MakeTableViewHolder, position: Int) {
        if (holder.binding == null) return
        holder.binding.viewModel = viewModel
        holder.binding.position = position
    }

    inner class MakeTableViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        val binding = DataBindingUtil.bind<MemberItemBinding>(root)
    }
}