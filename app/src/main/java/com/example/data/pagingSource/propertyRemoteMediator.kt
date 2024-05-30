package com.example.data.pagingSource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.data.local.dao.propertyRemoteKeyDao
import com.example.data.local.propertyDatabase
import com.example.data.remote.PropertyApi
import com.example.realhome.domain.model.Property
import com.example.realhome.domain.model.propertyRemoteKey
import javax.inject.Inject

@ExperimentalPagingApi
//@OptIn(ExperimentalPagingApi::class)
class propertyRemoteMediator @Inject constructor(
    private val PropertyApi: PropertyApi,
    private val propertyDatabase: propertyDatabase


) : RemoteMediator<Int, Property>() {

    private val propertyDao = propertyDatabase.propertyDao()
    private val propertyRemoteKeyDao = propertyDatabase.propertyRemoteKeyDao()


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Property>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.PREPEND -> {
                    val remotekey = getRemoteKeyClosetToCurrentPosition(state)
                    remotekey?.nextpage?.minus(1) ?: 1
                }

                LoadType.REFRESH -> {
                    val remoteKey = getRemoteKeyForFirst(state)
                    val prevpage = remoteKey?.prevpage
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKey != null)

                    prevpage
                }

                LoadType.APPEND -> {
                    val remoteKey = getRemoteKeyForLastItem(state)
                    val nextpage = remoteKey?.nextpage
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKey != null)
                    nextpage

                }
            }


            val respose = PropertyApi.getallproperties(page = page)
            if (respose.properties.isNotEmpty()) {
                propertyDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        propertyDao.deleteAllProperties()
                        propertyRemoteKeyDao.deleteAllRemoteKeys()
                    }
                    val prevpage = respose.prevpage
                    val nextpage = respose.nextpage
                    val keys = respose.properties.map { property ->
                        propertyRemoteKey(
                            id = property.id,
                            prevpage = prevpage,
                            nextpage = nextpage

                        )
                    }
                    propertyRemoteKeyDao.addAllRemoteKeys(keys)
                    propertyDao.addProperty(respose.properties)
                }

            }
            MediatorResult.Success(endOfPaginationReached = respose.nextpage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
        TODO("Not yet implemented")
    }


    private suspend fun getRemoteKeyClosetToCurrentPosition(state: PagingState<Int, Property>):
            propertyRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                propertyRemoteKeyDao.getRemoteKey(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirst(state: PagingState<Int, Property>): propertyRemoteKey? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { property ->
                propertyRemoteKeyDao.getRemoteKey(id = property.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Property>): propertyRemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { property -> propertyRemoteKeyDao.getRemoteKey(id = property.id) }
    }


}