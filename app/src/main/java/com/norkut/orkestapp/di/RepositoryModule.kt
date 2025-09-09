package com.norkut.orkestapp.di

import com.norkut.orkestapp.data.repository.DeviceTypeRepository
import com.norkut.orkestapp.domain.repository.IDeviceTypeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDeviceTypeRepository(impl: DeviceTypeRepository): IDeviceTypeRepository
}