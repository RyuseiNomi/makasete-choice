package com.teambrack.makasetechoice.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.teambrack.makasetechoice.di.ViewModelKey
import com.teambrack.makasetechoice.makegroup.MakeGroupActivity
import com.teambrack.makasetechoice.maketable.MakeTableActivity
import com.teambrack.makasetechoice.maketable.MakeTableViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MakeTableActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MakeTableActivitySubModule::class
        ]
    )
    abstract fun contributeMakeTableActivity(): MakeTableActivity
}

@Module
abstract class MakeTableActivitySubModule {
    @Binds
    abstract fun providesAppCompatActivity(makeTableActivity: MakeTableActivity): AppCompatActivity
    @Binds
    @IntoMap
    @ViewModelKey(MakeTableViewModel::class)
    abstract fun provideMakeTableViewModel(viewModel: MakeTableViewModel): ViewModel
}