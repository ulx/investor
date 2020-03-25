package ru.sberinvestor.dashboard.di

import androidx.lifecycle.SavedStateHandle
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.storage.InvestorRoomDatabase
import ru.sberbank.storage.InvestorRoomDatabase_Impl
import ru.sberbank.storage.dao.AssetDao
import ru.sberinvestor.dashboard.DashboardInteractor
import ru.sberinvestor.dashboard.DashboardRepository
import ru.sberinvestor.dashboard.DashboardViewModel

val dashboardModule : Module = module {
    viewModel { (handle: SavedStateHandle) -> DashboardViewModel(handle, get()) }
    factory { DashboardInteractor(get()) }
    factory { DashboardRepository(get() as InvestorServiceExecutor, get() as AssetDao) }
    factory {  InvestorRoomDatabase.getDatabase(androidContext()).assetDao() }
}