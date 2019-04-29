package com.teambrack.makasetechoice.maketable

import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.NavigationController
import com.teambrack.makasetechoice.data.MemberEntity
import javax.inject.Inject

class MakeTableViewModel @Inject constructor(
    private val navigator: NavigationController
) : ViewModel() {
    private val members = mutableListOf<MemberEntity>(MemberEntity(""))

    fun addMember(memberEntity: MemberEntity) {
        members.add(memberEntity)
    }

    fun removeMember(index: Int) {
        members.removeAt(index)
    }

    fun getMembers(): List<MemberEntity> = members.toList()

    fun onClickSave() {
        navigator.saveMember(members)
    }
}