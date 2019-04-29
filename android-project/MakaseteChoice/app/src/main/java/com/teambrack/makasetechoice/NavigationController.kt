package com.teambrack.makasetechoice

import androidx.appcompat.app.AppCompatActivity
import com.teambrack.makasetechoice.data.MemberEntity
import com.teambrack.makasetechoice.maketable.MakeTableFragment
import javax.inject.Inject

class NavigationController @Inject constructor(
    private val activity: AppCompatActivity
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}