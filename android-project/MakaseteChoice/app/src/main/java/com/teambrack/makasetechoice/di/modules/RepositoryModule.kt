package com.teambrack.makasetechoice.di.modules

import com.teambrack.makasetechoice.data.repository.MemberRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideMemberRepository(): MemberRepository = MemberRepository()
}