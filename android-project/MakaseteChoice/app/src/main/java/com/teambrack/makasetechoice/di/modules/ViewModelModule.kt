package com.teambrack.makasetechoice.di.modules

import androidx.lifecycle.ViewModelProvider
import com.teambrack.makasetechoice.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}