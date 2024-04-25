package com.example.data.Repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.local.propertyDatabase
import com.example.data.pagingSource.propertyRemoteMediator
import com.example.data.remote.PropertyApi
import com.example.realhome.domain.Repository.RemoteDataSource
import com.example.realhome.domain.model.Property
import com.example.realhome.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImp (
    private val propertyApi: PropertyApi,
    private val propertyDatabase: propertyDatabase): RemoteDataSource {
        private val propertyDao = propertyDatabase.propertyDao()
    @OptIn(ExperimentalPagingApi::class)
    override fun getAllData(): Flow<PagingData<Property>> {
   val pagingSourceFactory = {propertyDao.getAllProperty()}
        return Pager(config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = propertyRemoteMediator(
                propertyDatabase = propertyDatabase,
                PropertyApi = propertyApi

            ),pagingSourceFactory=pagingSourceFactory ).flow

    }

    override fun searchProperty(): Flow<PagingData<Property>> {
        TODO("Not yet implemented")
    }

}