package com.example.data.utils

import android.content.Context
import android.content.SharedPreferences

private const val SHARED_PREFERENCES_KEY = "applicationSharedPreferences"
private const val PREF_TAG_NAME = "pref_tag_name"

class StorageUtils(context: Context) {

    private var sharedPreference: SharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)

    fun saveTagName(name: String){
        sharedPreference.edit().putString(PREF_TAG_NAME, name).apply()
    }

    fun getTagName() = sharedPreference.getString(PREF_TAG_NAME, "")

}