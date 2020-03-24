package ru.sberinvestor.core.state

/**
 * Статус получения данных
 */
sealed class InvestorResult<out T: Any> {
    data class Success<out T: Any>(val code: CodeState, val data: T) : InvestorResult<T>()
    data class Error(val code: CodeState) : InvestorResult<Nothing>()
    data class Loading<out T: Any>( val data: T) : InvestorResult<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$code]"
            is Loading<*> -> "Loading[data=$data]"
        }
    }
}
