package ru.sberbank.sberinvestor.extenstion

import ru.sberbank.network.NetResult
import ru.sberinvestor.core.state.CodeState
import ru.sberinvestor.core.state.InvestorResult

fun <T: Any> NetResult<T>.toInvestorResult()  = when(this) {
    is NetResult.Success -> InvestorResult.Success(code = CodeState.getItem(statusCode), data = data )
    is NetResult.Failure -> InvestorResult.Error(code = CodeState.getItem(statusCode))
    is NetResult.NetworkError -> InvestorResult.Error(code = CodeState.NETWORK_ERROR)
}