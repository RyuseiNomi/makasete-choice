package com.teambrack.makasetechoice.data.repository

import com.teambrack.makasetechoice.data.entity.MemberEntity

class MemberRepository {
    private var cacheMembers: List<MemberEntity> = listOf()
    fun saveMembers(members: List<MemberEntity>): Boolean {
        cacheMembers = members
        return !cacheMembers.isNullOrEmpty()
    }

    fun loadMembers(): List<MemberEntity> = cacheMembers
}