package ru.sberbank.sberinvestor.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sberbank.network.Api

val netModule: Module = module {
    val baseUrl = "https://185.157.97.135:443/"
    val isMock = false
    single { Api(baseUrl).getServiceApi(isMock) }
}
