package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.propertyDao
import com.example.realhome.domain.model.Property

@Database(entities = [Property::class], version = 1)
abstract class propertyDatabase :RoomDatabase() {
    abstract fun propertyDao():propertyDao
}