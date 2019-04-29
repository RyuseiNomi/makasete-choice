package com.teambrack.makasetechoice.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.data.MemberEntity

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<MemberEntity>?) {
    if (items.isNullOrEmpty()) return
    adapter?.notifyDataSetChanged()
}