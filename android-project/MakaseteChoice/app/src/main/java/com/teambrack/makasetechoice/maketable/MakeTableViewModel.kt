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
    /**
     * データが可変なため`ObservableArrayList`を用いるようにしてある
     */
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

    fun removeMember(member: MemberEntity) {
        if (members.size == 1) return
        members.indexOf(member).also { position -> members.removeAt(position) }
    }

    fun addEmptyMember() {
        val maxId = members.maxBy { it.id }?.id?.plus(1) ?: 0
        members.add(MemberEntity(maxId, ""))
    }

    fun onClickSave() {
        navigator.saveMember(members)
    }
}