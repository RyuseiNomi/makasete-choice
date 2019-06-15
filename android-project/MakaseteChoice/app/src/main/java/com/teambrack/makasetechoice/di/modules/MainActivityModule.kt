package com.teambrack.makasetechoice.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.MainActivity
import com.teambrack.makasetechoice.di.ViewModelKey
import com.teambrack.makasetechoice.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivitySubModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainActivitySubModule {
    @Binds
    abstract fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(viewModel: HomeViewModel): ViewModel
}
