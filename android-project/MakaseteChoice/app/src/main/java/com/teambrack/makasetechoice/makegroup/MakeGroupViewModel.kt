package com.teambrack.makasetechoice.makegroup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.data.entity.GroupingEntity
import com.teambrack.makasetechoice.data.entity.MemberEntity
import com.teambrack.makasetechoice.data.repository.MemberRepository
import javax.inject.Inject

class MakeGroupViewModel @Inject constructor(
    private val repository: MemberRepository
) : ViewModel() {
    val members = MutableLiveData<List<MemberEntity>>()
    val grouping = MutableLiveData<List<GroupingEntity>>()
    val selectIndex = MutableLiveData<Int>()
    val groupingNumbers = MutableLiveData<List<Int>>()

    fun onLoad() {
        members.value = repository.loadMembers().also { members ->
            groupingNumbers.value = (1..members.size).toList()
        }
    }

    fun onClickShuffleButton() {
        grouping.value = shuffleMembers(
            groupingNumbers.value?.get(selectIndex.value ?: 0) ?: 1,
            members.value ?: listOf()
        )
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