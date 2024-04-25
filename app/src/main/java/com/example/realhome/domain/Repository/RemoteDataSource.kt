package com.example.realhome.domain.Repository

import androidx.paging.PagingData
import com.example.realhome.domain.model.Property
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllData():Flow<PagingData<Property>>
    fun searchProperty():Flow<PagingData<Property>>
}