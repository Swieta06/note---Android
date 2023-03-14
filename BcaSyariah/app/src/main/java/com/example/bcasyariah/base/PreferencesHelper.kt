package com.example.bcasyariah.base

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun saveName(value: String) {
        sharedPreferences.edit().putString(KEY_NAME, value).apply()
    }

    fun getName(): String? {
        return sharedPreferences.getString(KEY_NAME, "-")
    }

    fun saveAdress(value: String) {
        sharedPreferences.edit().putString(KEY_ADRESS, value).apply()
    }

    fun getAdress(): String? {
        return sharedPreferences.getString(KEY_ADRESS, "-")
    }

    fun clearDataPref() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ADRESS = "key_adress"
    }
}