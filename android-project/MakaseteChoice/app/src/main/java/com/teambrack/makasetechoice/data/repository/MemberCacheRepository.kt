package com.teambrack.makasetechoice.data.repository

import com.teambrack.makasetechoice.data.MemberEntity

class MemberCacheRepository : MemberRepository {
    private var cacheMembers: List<MemberEntity> = listOf()
    override fun saveMembers(members: List<MemberEntity>) {
        cacheMembers = members
    }
    override fun loadMembers(): List<MemberEntity> = cacheMembers

}