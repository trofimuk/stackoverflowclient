package com.example.data.utils

import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Contains support methods for http requests
 *
 * @author Artyom Trofimuk
 */
class HttpClientUtils(settingsProvider: SettingsProvider): KoinComponent {

    private val retrofit: Retrofit

    val instance: ServiceAPI
        get() = retrofit.create(ServiceAPI::class.java)

    init {
        val httpClient = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)
        httpClient.networkInterceptors().add(logging)

        retrofit = Retrofit.Builder()
                .baseUrl(settingsProvider.getServerUrl())
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                .build()
    }
}