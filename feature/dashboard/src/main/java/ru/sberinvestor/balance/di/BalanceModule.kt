package ru.sberinvestor.balance.di

import androidx.lifecycle.SavedStateHandle
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.sberinvestor.balance.BalanceViewModule
import org.koin.androidx.viewmodel.dsl.viewModel

val balanceModule : Module = module {

    viewModel { (handle: SavedStateHandle) -> BalanceViewModule(handle) }
}