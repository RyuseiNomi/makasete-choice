package com.teambrack.makasetechoice.home

import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.NavigationController
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val navigator: NavigationController
) : ViewModel() {

    fun onClickMakeTable() {
        navigator.moveMakeTable()
    }

    fun onClickMakeGroup() {
        navigator.moveMakeGroup()
    }

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }
}