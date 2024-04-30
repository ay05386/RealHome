package com.example.realhome.di

import com.example.data.Repository.Repository
import com.example.realhome.domain.useCases.get_All_Property.GetAllPropertyUseCase
import com.example.realhome.domain.useCases.useCases

object RepositoryModule {
    fun provideUseCases(repository: Repository):useCases{
        return useCases(
            getAllPropertyUseCase = GetAllPropertyUseCase(repository)
        )
    }
}