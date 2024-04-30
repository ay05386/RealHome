package com.example.data.Repository

import androidx.paging.PagingData
import com.example.realhome.domain.Repository.RemoteDataSource
import com.example.realhome.domain.model.Property
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote :RemoteDataSource
) {
  fun getAllData():Flow<PagingData<Property>>{
      return remote.getAllData()
  }
}