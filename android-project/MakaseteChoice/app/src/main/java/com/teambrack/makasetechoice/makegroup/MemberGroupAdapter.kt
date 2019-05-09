package com.teambrack.makasetechoice.makegroup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.data.entity.GroupingEntity
import com.teambrack.makasetechoice.data.entity.MemberEntity
import com.teambrack.makasetechoice.databinding.GroupRowBinding
import com.teambrack.makasetechoice.ext.setListViewHeightBasedOnChildren
import kotlinx.android.synthetic.main.group_row.view.*

class MemberGroupAdapter(
    private val viewModel: MakeGroupViewModel
) : RecyclerView.Adapter<MemberGroupAdapter.MemberGroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberGroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.group_row, parent, false)

        return MemberGroupViewHolder(parent.context, view)
    }

    override fun getItemCount() = viewModel.groupedMembers.value?.size ?: 0

    override fun onBindViewHolder(holder: MemberGroupViewHolder, position: Int) {
        if (holder.binding == null) return
        val group = viewModel.groupedMembers.value?.get(position) ?: GroupingEntity("", emptyList())
        holder.binding.number = group.number
        holder.setListView(group.members)
    }

    inner class MemberGroupViewHolder(
        private val context: Context,
        private val root: View
    ) : RecyclerView.ViewHolder(root) {
        val binding = DataBindingUtil.bind<GroupRowBinding>(root)

        fun setListView(members: List<MemberEntity>) {
            root.group_member.adapter =
                ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, members.map { it.name })
            root.group_member.setListViewHeightBasedOnChildren()
        }
    }
}