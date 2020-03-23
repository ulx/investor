package ru.sberbank.sberinvestor.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sberbank.network.Api

val netModule: Module = module {
    val baseUrl = "baseurl"
    single { Api(baseUrl) }
}
