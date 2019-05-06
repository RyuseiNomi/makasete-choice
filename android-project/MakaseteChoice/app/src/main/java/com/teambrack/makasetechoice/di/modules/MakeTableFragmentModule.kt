package com.teambrack.makasetechoice.di.modules

import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.di.ViewModelKey
import com.teambrack.makasetechoice.maketable.MakeTableFragment
import com.teambrack.makasetechoice.maketable.MakeTableViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MakeTableFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            MakeTableFragmentSubModule::class
        ]
    )
    abstract fun contributeMakeTableFragment(): MakeTableFragment
}

@Module
abstract class MakeTableFragmentSubModule {
    @Binds
    @IntoMap
    @ViewModelKey(MakeTableViewModel::class)
    abstract fun provideMakeTableViewModel(viewModel: MakeTableViewModel): ViewModel
}