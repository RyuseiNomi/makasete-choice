package com.teambrack.makasetechoice.makegroup

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.data.entity.GroupingEntity
import com.teambrack.makasetechoice.data.entity.MemberEntity

class MakeGroupViewModel : ViewModel() {
    val members = ObservableArrayList<MemberEntity>()
    val grouping = MutableLiveData<List<GroupingEntity>>()
}