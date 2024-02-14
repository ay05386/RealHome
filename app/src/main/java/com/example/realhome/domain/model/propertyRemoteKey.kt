package com.example.realhome.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.realhome.util.Constants.PROPERTY_REMOTE_KEY_DATABASE_TABLE

@Entity(tableName = PROPERTY_REMOTE_KEY_DATABASE_TABLE)
data class propertyRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id :Int,
    val nextpage :Int?,
    val prevpage:Int?
)

