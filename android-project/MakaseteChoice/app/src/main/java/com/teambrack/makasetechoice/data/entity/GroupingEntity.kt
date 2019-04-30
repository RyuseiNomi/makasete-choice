package com.teambrack.makasetechoice.data.entity

data class GroupingEntity(
    val number: String,
    val members: List<MemberEntity>
) : MakaseteChoiceEntity