package com.example.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.realhome.domain.model.Property
import java.sql.RowId
import java.util.Properties

@Dao
interface propertyDao {
@Query("SELECT * FROM property_table ORDER BY id ASC")
    fun getAllProperty():PagingSource<Int,Property>
@Query("SELECT * FROM property_table WHERE id=:propertyId")
    fun getSelectedProperty(propertyId: Int):Property
@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  addHeroes(properties: List<Property>)



}