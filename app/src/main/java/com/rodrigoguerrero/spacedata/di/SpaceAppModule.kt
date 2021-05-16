package com.rodrigoguerrero.spacedata.di

import com.rodrigoguerrero.spacedata.datastore.DataStoreRepository
import com.rodrigoguerrero.spacedata.datastore.DataStoreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SpaceAppModule {

    @Binds
    abstract fun bindDataStoreRepository(dataStoreRepository: DataStoreRepositoryImpl): DataStoreRepository
}