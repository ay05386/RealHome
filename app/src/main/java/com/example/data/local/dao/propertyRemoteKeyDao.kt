package com.example.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.realhome.domain.model.propertyRemoteKey

interface propertyRemoteKeyDao {
    @Query("SELECT * FROM PROPERTY_REMOTE_KEY_TABLE WHERE id = :id")
    suspend fun getRemoteKey(id:Int): propertyRemoteKey?
@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(propertyRemoteKey: List<propertyRemoteKey>)

    @Query("DELETE FROM PROPERTY_REMOTE_KEY_TABLE ")
    suspend fun deleteAllRemoteKeys()
}