package com.example.realhome.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.propertyDatabase
import com.example.realhome.util.Constants.PROPERTY_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object databaseModule {
@Provides
@Singleton
    fun providerDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,propertyDatabase::class.java,PROPERTY_DATABASE).build()


}