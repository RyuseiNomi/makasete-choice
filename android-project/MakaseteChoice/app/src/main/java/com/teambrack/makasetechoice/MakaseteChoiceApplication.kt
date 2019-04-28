package com.teambrack.makasetechoice

import com.teambrack.makasetechoice.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MakaseteChoiceApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().app(this).build()
    }
}