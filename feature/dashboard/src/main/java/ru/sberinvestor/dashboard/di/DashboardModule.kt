package ru.sberinvestor.dashboard.di

import androidx.lifecycle.SavedStateHandle
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.sberinvestor.dashboard.DashboardViewModule

val dashboardModule : Module = module {
    viewModel { (handle: SavedStateHandle) -> DashboardViewModule(handle) }
}