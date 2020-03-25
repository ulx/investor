package ru.sberinvestor.dashboard

import android.util.Log
import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.network.entity.Dictionaries
import ru.sberbank.sberinvestor.extenstion.toAssetDb
import ru.sberbank.sberinvestor.extenstion.toInvestorResult
import ru.sberbank.storage.dao.AssetDao
import ru.sberinvestor.core.state.InvestorResult

class DashboardRepository(private val netSource: InvestorServiceExecutor, private val assetDao : AssetDao) {

    suspend fun getDictionaries() : InvestorResult<Dictionaries> {
       val result = netSource.getDictionaries().toInvestorResult()
        if (result is InvestorResult.Success){
            result.data.resp.assets.forEach{
               Log.i("DashboardRepository", "index = ${assetDao.insert(it.toAssetDb())}")
            }
        }
        return result
    }
}