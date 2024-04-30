package com.example.realhome.domain.useCases.get_All_Property

import androidx.paging.PagingData
import com.example.data.Repository.Repository
import com.example.realhome.domain.model.Property
import kotlinx.coroutines.flow.Flow

class GetAllPropertyUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Property>> {
        return repository.getAllData()
    }
}