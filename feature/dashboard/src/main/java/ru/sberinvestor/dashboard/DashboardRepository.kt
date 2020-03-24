package ru.sberinvestor.dashboard

import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.sberinvestor.extenstion.toInvestorResult
import ru.sberinvestor.core.state.InvestorResult

class DashboardRepository(private val netSource: InvestorServiceExecutor) {

    suspend fun getDictionaries() = netSource.getDictionaries().toInvestorResult()
}