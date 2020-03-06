package com.example.data.utils

private const val SERVER_URL = "https://api.stackexchange.com/2.2/"

/**
 * Implementation for [SettingsProvider]
 *
 * @author Artyom Trofimuk
 */
class SettingsProviderImpl : SettingsProvider {

    override fun getServerUrl(): String = SERVER_URL

}