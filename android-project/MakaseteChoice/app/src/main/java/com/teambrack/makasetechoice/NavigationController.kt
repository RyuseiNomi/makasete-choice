package com.teambrack.makasetechoice

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teambrack.makasetechoice.data.entity.MemberEntity
import com.teambrack.makasetechoice.data.repository.MemberRepository
import com.teambrack.makasetechoice.makegroup.MakeGroupFragment
import com.teambrack.makasetechoice.maketable.MakeTableFragment
import javax.inject.Inject

class NavigationController @Inject constructor(
    private val activity: AppCompatActivity,
    private val memberRepository: MemberRepository
) {
    fun moveMakeTable() {
        activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_area, MakeTableFragment.newInstance(), MakeTableFragment.FRAGMENT_TAG)
            addToBackStack(MakeTableFragment.FRAGMENT_TAG)
            commit()
        }
    }

    fun moveMakeGroup() {
        activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_area, MakeGroupFragment.newInstance(), MakeGroupFragment.FRAGMENT_TAG)
            addToBackStack(MakeGroupFragment.FRAGMENT_TAG)
            commit()
        }
    }

    fun saveMember(members: List<MemberEntity>) {
        if (memberRepository.saveMembers(members)) {
            Toast.makeText(activity, "保存が成功しました。", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activity, "保存が失敗しました。", Toast.LENGTH_LONG).show()
        }
    }

    fun showError() {
        Toast.makeText(activity, "生徒表を登録してから組み分けを行ってください。", Toast.LENGTH_LONG).show()
    }

}