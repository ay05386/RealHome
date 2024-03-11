package com.example.realhome.di

import com.example.data.remote.PropertyApi
import com.example.realhome.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object networkModule {

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


}