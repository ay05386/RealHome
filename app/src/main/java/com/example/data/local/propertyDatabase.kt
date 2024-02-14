package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.data.local.dao.propertyDao
import com.example.data.local.dao.propertyRemoteKeyDao
import com.example.realhome.domain.model.Property
import com.example.realhome.domain.model.propertyRemoteKey

@Database(entities = [Property::class,propertyRemoteKey::class], version = 1)
@TypeConverters(databaseConverter::class)
abstract class propertyDatabase :RoomDatabase() {
    abstract fun propertyDao():propertyDao
    abstract fun propertyRemoteKeyDao():propertyRemoteKeyDao
}