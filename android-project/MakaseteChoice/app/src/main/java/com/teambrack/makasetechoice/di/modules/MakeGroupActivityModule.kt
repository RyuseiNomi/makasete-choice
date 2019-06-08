package com.teambrack.makasetechoice.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.di.ViewModelKey
import com.teambrack.makasetechoice.makegroup.MakeGroupActivity
import com.teambrack.makasetechoice.makegroup.MakeGroupViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MakeGroupActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MakeGroupActivitySubModule::class
        ]
    )
    abstract fun contributeMakeGroupActivity(): MakeGroupActivity
}

@Module
abstract class MakeGroupActivitySubModule {
    @Binds
    abstract fun providesAppCompatActivity(makeGroupActivity: MakeGroupActivity): AppCompatActivity
    @Binds
    @IntoMap
    @ViewModelKey(MakeGroupViewModel::class)
    abstract fun provideMakeGroupViewModel(viewModel: MakeGroupViewModel): ViewModel
}