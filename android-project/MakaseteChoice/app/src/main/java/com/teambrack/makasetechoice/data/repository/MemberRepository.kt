package com.teambrack.makasetechoice.data.repository

import android.content.Context
import androidx.core.content.edit
import com.squareup.moshi.Moshi
import com.teambrack.makasetechoice.data.ApplicationJsonAdapterFactory
import com.teambrack.makasetechoice.data.entity.MemberEntity
import se.ansman.kotshi.JsonSerializable

class MemberRepository(
    private val context: Context
) {
    private val moshi = Moshi.Builder()
        .add(ApplicationJsonAdapterFactory.INSTANCE)
        .build()
    private var cacheMembers: List<MemberEntity> = listOf()

    fun saveMembers(members: List<MemberEntity>): Boolean {
        saveSharedPreferences(members).also {
            cacheMembers = members
        }
        return !cacheMembers.isNullOrEmpty()
    }

    fun loadMembers(): List<MemberEntity> {
        return if (cacheMembers.isNullOrEmpty()) {
            loadSharedPreferences().also { loadingMembers ->
                cacheMembers = loadingMembers
            }
        } else {
            cacheMembers
        }
    }

    private fun saveSharedPreferences(members: List<MemberEntity>) {
        context.getSharedPreferences(
            PREFERENCES_NAME,
            Context.MODE_PRIVATE
        ).edit {
            moshi.adapter(MemberSaveTemplate::class.java)
                .toJson(MemberSaveTemplate(members)).also { json ->
                    putString(KEY, json)
                }
        }
    }

    private fun loadSharedPreferences(): List<MemberEntity> {
        return context.getSharedPreferences(
            PREFERENCES_NAME,
            Context.MODE_PRIVATE
        ).getString(KEY, null)?.let { data ->
            moshi.adapter(MemberSaveTemplate::class.java)
                .fromJson(data)
        }?.members ?: emptyList()
    }

    @JsonSerializable
    data class MemberSaveTemplate(val members: List<MemberEntity>)

    companion object {
        private val PACKAGE_NAME = MemberRepository::class.java.`package`
        private val PREFERENCES_NAME = "${PACKAGE_NAME}_members"
        private const val KEY = "members"
    }
}