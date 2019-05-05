package com.teambrack.makasetechoice.maketable

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.NavigationController
import com.teambrack.makasetechoice.data.entity.MemberEntity
import com.teambrack.makasetechoice.data.repository.MemberRepository
import javax.inject.Inject

class MakeTableViewModel @Inject constructor(
    private val navigator: NavigationController,
    private val repository: MemberRepository
) : ViewModel() {
    val members = ObservableArrayList<MemberEntity>()

    fun onLoad() {
        if (members.isNullOrEmpty()) {
            //初めにrepositoryを介してデータを持ってくる
            members.addAll(repository.loadMembers())
            if (members.isNullOrEmpty()) {
                //repositoryからデータを取れないときは空のメンバーを保存
                addEmptyMember()
            }
        }
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