package com.bcas.restplayground

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object ProductModule {
    @Provides
    fun installwebService(): ProductWebService {
        return ProductWebService.bulider()
    }
}