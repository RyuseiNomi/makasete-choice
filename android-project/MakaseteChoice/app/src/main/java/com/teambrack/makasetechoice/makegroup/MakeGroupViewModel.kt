package com.teambrack.makasetechoice.makegroup

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.data.entity.GroupingEntity
import com.teambrack.makasetechoice.data.entity.MemberEntity
import com.teambrack.makasetechoice.data.repository.MemberRepository
import javax.inject.Inject

class MakeGroupViewModel @Inject constructor(
    private val repository: MemberRepository
) : ViewModel() {
    val members = ObservableArrayList<MemberEntity>()
    val grouping = MutableLiveData<List<GroupingEntity>>()
    val groupingNumber = 1

    fun onLoad() {
        members.addAll(repository.loadMembers())
    }

    fun onClickShuffleButton() {
        grouping.value = shuffleMembers(groupingNumber, members)
    }

    private fun shuffleMembers(groupingNumber: Int, members: List<MemberEntity>): List<GroupingEntity> {
        return members.shuffled().let { shuffleMembers ->
            shuffleMembers.mapIndexed { index, memberEntity ->
                index to memberEntity
            }.groupBy({ (index, _) ->
                index % groupingNumber
            }, { (_, memberEntity) ->
                memberEntity
            }).flatMap {
                listOf(GroupingEntity(it.key.toString(), it.value))
            }
        }
    }
}