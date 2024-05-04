package com.example.realhome.di

import com.example.data.Repository.Repository
import com.example.realhome.domain.useCases.get_All_Property.GetAllPropertyUseCase
import com.example.realhome.domain.useCases.useCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUseCases(repository: Repository):useCases{
        return useCases(
            getAllPropertyUseCase = GetAllPropertyUseCase(repository)
        )
    }
}