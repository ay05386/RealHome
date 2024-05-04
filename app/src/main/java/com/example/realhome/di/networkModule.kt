package com.example.realhome.di

import androidx.paging.ExperimentalPagingApi
import com.example.data.Repository.RemoteDataSourceImp
import com.example.data.local.propertyDatabase
import com.example.data.remote.PropertyApi
import com.example.realhome.domain.Repository.RemoteDataSource
import com.example.realhome.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object networkModule {
@Provides
@Singleton
    fun providehttpclient():OkHttpClient{
        return OkHttpClient.Builder().readTimeout(15,TimeUnit.MINUTES)
            .connectTimeout(15,TimeUnit.MINUTES).build()
    }


    @Provides
    @Singleton
    fun provideretrfitinstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType)).build()

    }
    @Provides
    @Singleton
    fun providePropertyApi(retrofit: Retrofit):PropertyApi{
        return retrofit.create(PropertyApi::class.java)
    }
    @Provides
    @Singleton
    fun provideRemoteDataSource(propertyApi: PropertyApi,propertyDatabase: propertyDatabase)
    :RemoteDataSource{
        return RemoteDataSourceImp(propertyDatabase = propertyDatabase, propertyApi = propertyApi)

    }


}