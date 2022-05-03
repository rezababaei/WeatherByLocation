package com.rezababaei.weatherbylocation.di


import com.rezababaei.weatherbylocation.db.SharedPrefRepository
import com.rezababaei.weatherbylocation.db.SharedPrefRepositoryImp
import com.rezababaei.weatherbylocation.network.ApiRepository
import com.rezababaei.weatherbylocation.network.ApiRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {

    @Binds
    abstract fun provideApiRepository(apiRepositoryImp: ApiRepositoryImp): ApiRepository

    @Binds
    abstract fun provideSharedPrefRepository(sharedPref: SharedPrefRepositoryImp): SharedPrefRepository

}