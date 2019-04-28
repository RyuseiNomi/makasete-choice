package com.teambrack.makasetechoice.di

import com.teambrack.makasetechoice.MakaseteChoiceApplication
import com.teambrack.makasetechoice.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MakaseteChoiceApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: MakaseteChoiceApplication): Builder

        fun build(): ApplicationComponent
    }
}