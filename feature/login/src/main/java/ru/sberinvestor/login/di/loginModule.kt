package ru.sberinvestor.balance.di

import androidx.lifecycle.SavedStateHandle
import org.koin.core.module.Module
import org.koin.dsl.module

import org.koin.androidx.viewmodel.dsl.viewModel
import ru.sberinvestor.login.LoginViewModel

val loginModule : Module = module {
    viewModel { (handle: SavedStateHandle) -> LoginViewModel(handle) }
}