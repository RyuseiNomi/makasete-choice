package com.teambrack.makasetechoice.data.repository

import com.teambrack.makasetechoice.data.MemberEntity

class MemberCacheRepository : MemberRepository {
    private var cacheMembers: List<MemberEntity> = listOf()
    override fun saveMembers(members: List<MemberEntity>): Boolean {
        cacheMembers = members
        return !cacheMembers.isNullOrEmpty()
    }

    override fun loadMembers(): List<MemberEntity> = cacheMembers

}