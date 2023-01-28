package com.algorithm_questions_visualizer.di

import com.algorithm_questions_visualizer.data.repository.ProblemsRepository
import com.algorithm_questions_visualizer.data.repository.ProblemsRepositoryImpl
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
    abstract fun bindDashboardRepository(
        problemsRepositoryImpl: ProblemsRepositoryImpl
    ): ProblemsRepository
}