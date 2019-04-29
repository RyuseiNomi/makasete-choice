package com.teambrack.makasetechoice.maketable

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.NavigationController
import com.teambrack.makasetechoice.data.MemberEntity
import javax.inject.Inject

class MakeTableViewModel @Inject constructor(
    private val navigator: NavigationController
) : ViewModel() {
    val members = ObservableArrayList<MemberEntity>()

    init {
        addEmptyMember()
    }

    fun addMember(memberEntity: MemberEntity) {
        members.add(memberEntity)
    }

    fun removeMember(index: Int) {
        if (members.size == 1) return
        members.removeAt(index)
    }

    fun addEmptyMember() {
        addMember(MemberEntity(""))
    }

    fun getMembers(): List<MemberEntity> = members.toList()

    fun onClickSave() {
        navigator.saveMember(getMembers())
    }
}