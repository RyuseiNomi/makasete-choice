package com.teambrack.makasetechoice.di.modules

import androidx.appcompat.app.AppCompatActivity
import com.teambrack.makasetechoice.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivitySubModule::class,
            HomeFragmentModule::class,
            MakeTableFragmentModule::class,
            MakeGroupFragmentModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainActivitySubModule {
    @Binds
    abstract fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
}
