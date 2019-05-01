package com.teambrack.makasetechoice.di.modules

import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.di.ViewModelKey
import com.teambrack.makasetechoice.makegroup.MakeGroupFragment
import com.teambrack.makasetechoice.makegroup.MakeGroupViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MakeGroupFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            MakeGroupFragmentSubModule::class
        ]
    )
    abstract fun contributeMakeGroupFragment(): MakeGroupFragment
}

@Module
abstract class MakeGroupFragmentSubModule {
    @Binds
    @IntoMap
    @ViewModelKey(MakeGroupViewModel::class)
    abstract fun provideMakeGroupViewModel(viewModel: MakeGroupViewModel): ViewModel
}