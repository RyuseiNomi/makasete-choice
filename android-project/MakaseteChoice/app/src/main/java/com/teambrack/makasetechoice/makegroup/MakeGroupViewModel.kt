package com.teambrack.makasetechoice.makegroup

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.data.MemberEntity

class MakeGroupViewModel : ViewModel(){
    val members = ObservableArrayList<MemberEntity>()
}