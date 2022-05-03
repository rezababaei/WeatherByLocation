package com.rezababaei.weatherbylocation.di

import android.content.Context
import android.content.SharedPreferences
import com.rezababaei.weatherbylocation.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModules {

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext appContext: Context): SharedPreferences =
        appContext.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)

}