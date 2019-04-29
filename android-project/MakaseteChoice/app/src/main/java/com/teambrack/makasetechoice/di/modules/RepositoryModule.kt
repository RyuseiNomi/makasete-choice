package com.teambrack.makasetechoice.di.modules

import com.teambrack.makasetechoice.data.repository.MemberCacheRepository
import com.teambrack.makasetechoice.data.repository.MemberRepository
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {
    @JvmStatic
    @Provides
    fun provideMemberRepository(): MemberRepository = MemberCacheRepository()
}