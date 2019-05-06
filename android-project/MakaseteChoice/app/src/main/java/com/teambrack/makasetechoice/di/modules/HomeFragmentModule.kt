package com.teambrack.makasetechoice.di.modules

import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.di.ViewModelKey
import com.teambrack.makasetechoice.home.HomeFragment
import com.teambrack.makasetechoice.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentSubModule::class
        ]
    )
    abstract fun contributeHomeFragment(): HomeFragment
}

@Module
abstract class HomeFragmentSubModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(viewModel: HomeViewModel): ViewModel
}