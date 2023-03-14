package com.example.bcasyariah

import com.example.bcasyariah.model.Engine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EngineModule {
    @Singleton
    @Provides
    fun provideEngine():Engine{
        return Engine()
    }
}