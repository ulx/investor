package ru.sberinvestor.dashboard

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.network.entity.Dictionaries
import ru.sberbank.sberinvestor.extenstion.toAssetDb
import ru.sberbank.sberinvestor.extenstion.toInvestorResult
import ru.sberbank.storage.dao.AssetDao
import ru.sberinvestor.core.state.InvestorResult

class DashboardRepository(private val netSource: InvestorServiceExecutor, private val assetDao: AssetDao) {

    suspend fun getDictionaries(): Flow<InvestorResult<Dictionaries>> = flow {
        val result = netSource.getDictionaries().toInvestorResult()
        if (result is InvestorResult.Success) {
            result.data.resp.assets.forEach {
                Log.i("DashboardRepository", "index = ${assetDao.insert(it.toAssetDb())}")
            }
        }

        val l = assetDao.getAlphabetizedWords()
        Log.i("DashboardRepository", l.joinToString())

        if (result is InvestorResult.Success) {
            emit(InvestorResult.Loading(result.data))
        }
        delay(2000)
        emit(result)
    }
}