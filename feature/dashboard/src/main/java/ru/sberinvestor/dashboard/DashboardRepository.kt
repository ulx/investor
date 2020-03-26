package ru.sberinvestor.dashboard

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.network.entity.Dictionaries
import ru.sberbank.sberinvestor.extenstion.toAssetDb
import ru.sberbank.sberinvestor.extenstion.toInvestorResult
import ru.sberbank.storage.dao.AssetDao
import ru.sberinvestor.core.state.CodeState
import ru.sberinvestor.core.state.InvestorResult

class DashboardRepository(private val netSource: InvestorServiceExecutor, private val assetDao: AssetDao) {

    suspend fun getDictionaries(): InvestorResult<Dictionaries> {
        val result = netSource.getDictionaries().toInvestorResult()
        if (result is InvestorResult.Success) {
            result.data.resp.assets.forEach {
                Log.i("DashboardRepository", "index = ${assetDao.insert(it.toAssetDb())}")
            }
        }
        withContext(Dispatchers.IO) {
            val l = assetDao.getAlphabetizedWords()
            Log.i("DashboardRepository", l.joinToString())
        }
        return result
    }

    suspend fun getDictionaries2(): Flow<InvestorResult<Int>> = flow {
        for (i in 1..1000) {
            delay(1000)
            if (i < 10 ) {
                emit(InvestorResult.Loading(i))
            } else {
                emit(InvestorResult.Success(CodeState.OK, i))
            }

        }
    }
}