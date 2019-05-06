package com.teambrack.makasetechoice.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.data.entity.MakaseteChoiceEntity

@BindingAdapter("items")
fun RecyclerView.bindItems(items: List<MakaseteChoiceEntity>?) {
    if (items.isNullOrEmpty()) return
    adapter?.notifyDataSetChanged()
}