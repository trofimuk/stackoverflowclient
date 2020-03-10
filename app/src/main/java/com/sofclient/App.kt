package com.sofclient

import android.app.Application
import com.example.data.questions.QuestionsGateway
import com.example.data.questions.QuestionsGatewayImpl
import com.example.data.tagDetails.TagDetailsGateway
import com.example.data.tagDetails.TagDetailsGatewayImpl
import com.example.data.tags.TagsGateway
import com.example.data.tags.TagsGatewayImpl
import com.example.data.utils.HttpClientUtils
import com.example.data.utils.SettingsProvider
import com.example.data.utils.SettingsProviderImpl
import com.example.data.utils.StorageUtils
import com.example.domain.questions.QuestionsUseCase
import com.example.domain.questions.QuestionsUseCaseImpl
import com.example.domain.tagDetails.TagDetailsUseCase
import com.example.domain.tagDetails.TagDetailsUseCaseImpl
import com.example.domain.tags.TagsUseCase
import com.example.domain.tags.TagsUseCaseImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Custom [Application] class
 *
 * @author Artyom Trofimuk
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {

        val storageModule = module {
            single { StorageUtils(this@App) }
        }

        val useCaseModule = module {
            single { QuestionsUseCaseImpl(questionsGateway = get()) as QuestionsUseCase }
            single { TagsUseCaseImpl(tagsGateway = get()) as TagsUseCase }
            single { TagDetailsUseCaseImpl(tagDetailsGateway = get()) as TagDetailsUseCase }
        }

        val dataGatewayModule = module {
            single { QuestionsGatewayImpl(httpClientUtils = get()) as QuestionsGateway }
            single { TagsGatewayImpl(httpClientUtils = get()) as TagsGateway }
            single { TagDetailsGatewayImpl(httpClientUtils = get()) as TagDetailsGateway }
            single { HttpClientUtils(settingsProvider = get()) }
        }

        val settingsModule = module {
            single { SettingsProviderImpl() as SettingsProvider }
        }

        startKoin {
            modules(listOf(useCaseModule, dataGatewayModule, settingsModule, storageModule))
        }
    }

}