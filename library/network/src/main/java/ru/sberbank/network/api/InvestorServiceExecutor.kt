package ru.sberbank.network.api

import ru.sberbank.network.NetResult
import ru.sberbank.network.entity.Dictionaries
import java.io.IOException

class InvestorServiceExecutor(val isMock: Boolean = false, val api : InvestorService, val mock: InvestorService) {


    private var service: InvestorService = if (isMock) {
        mock
    }else{
        api
    }

    suspend fun getDictionaries(): NetResult<Dictionaries> {
        try {
            val result = service.getDictionaries()
            if (result.isSuccessful) {
                return NetResult.Success(
                    result.code(), result.body() ?: Dictionaries()
                )
            }else {
                NetResult.Failure(result.code())
            }
        } catch(exception: IOException) {
            return NetResult.NetworkError
        }
        return NetResult.NetworkError
    }
}