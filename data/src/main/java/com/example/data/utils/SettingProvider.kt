package com.example.data.utils

/**
 * Provides base remote service settings
 *
 * @author Artyom Trofimuk
 */
interface SettingsProvider {

    /**
     * Returns remote service url
     */
    fun getServerUrl(): String

}