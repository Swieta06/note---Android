package com.example.bcasyariah.base

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

interface SharePreferenceModule {
    fun provideSharePreferences(context: Context):SharedPreferences
}