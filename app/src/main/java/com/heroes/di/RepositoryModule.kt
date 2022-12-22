package com.heroes.di

import com.heroes.data.repository.DashboardRepository
import com.heroes.data.repository.DashboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHeroesRepository(
        dashboardRepositoryImpl: DashboardRepositoryImpl
    ): DashboardRepository
}