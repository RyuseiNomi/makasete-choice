package com.teambrack.makasetechoice

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teambrack.makasetechoice.data.entity.MemberEntity
import com.teambrack.makasetechoice.data.repository.MemberRepository
import com.teambrack.makasetechoice.makegroup.MakeGroupActivity
import com.teambrack.makasetechoice.maketable.MakeTableActivity
import javax.inject.Inject

class NavigationController @Inject constructor(
    private val activity: AppCompatActivity,
    private val memberRepository: MemberRepository
) {
    fun moveMakeTable() {
        MakeTableActivity.startActivity(activity)
    }

    fun moveMakeGroup() {
        MakeGroupActivity.startActivity(activity)
    }

    fun saveMember(members: List<MemberEntity>) {
        if (memberRepository.saveMembers(members)) {
            Toast.makeText(activity, activity.getString(R.string.save_success), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activity, activity.getString(R.string.save_error), Toast.LENGTH_LONG).show()
        }
    }

    fun showError() {
        Toast.makeText(activity, activity.getString(R.string.empty_member_error), Toast.LENGTH_LONG).show()
    }

}