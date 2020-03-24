package ru.sberbank.network.api

import retrofit2.Response
import retrofit2.http.POST
import ru.sberbank.network.entity.Dictionaries

interface InvestorService {
    @POST("api/dictionaries/get_dictionaries")
    suspend fun getDictionaries(): Response<Dictionaries>
}
