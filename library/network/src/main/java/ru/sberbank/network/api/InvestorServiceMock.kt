package ru.sberbank.network.api

import retrofit2.Response
import retrofit2.mock.BehaviorDelegate
import ru.sberbank.network.entity.Dictionaries

class InvestorServiceMock(private val delegate: BehaviorDelegate<InvestorService>) : InvestorService {
    override suspend fun getDictionaries(): Response<Dictionaries> {
        return delegate.returningResponse(Response.success(Dictionaries())).getDictionaries()
    }
}