package ru.sberinvestor.dashboard

import ru.sberbank.network.entity.Dictionaries
import ru.sberinvestor.core.state.InvestorResult

/**
 * Возможно надо будет соединять логику из нескольких репозиториев
 * Так же тут должна быть проваерка на авторизацию
 */
class DashboardInteractor(private val repo : DashboardRepository) {
    suspend fun getDictionaries() : InvestorResult<Dictionaries> = repo.getDictionaries()
}