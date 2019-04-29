package com.teambrack.makasetechoice

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teambrack.makasetechoice.data.MemberEntity
import com.teambrack.makasetechoice.data.repository.MemberRepository
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun saveMember(members: List<MemberEntity>) {
        if (memberRepository.saveMembers(members)) {
            Toast.makeText(activity, "保存が成功しました。", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activity, "保存が失敗しました。", Toast.LENGTH_LONG).show()
        }
    }

}