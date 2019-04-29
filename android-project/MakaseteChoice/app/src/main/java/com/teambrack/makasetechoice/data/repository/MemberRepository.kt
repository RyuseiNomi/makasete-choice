package com.teambrack.makasetechoice.data.repository

import com.teambrack.makasetechoice.data.MemberEntity

interface MemberRepository {
    fun saveMembers(members: List<MemberEntity>)
    fun loadMembers(): List<MemberEntity>
}