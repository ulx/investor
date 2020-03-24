package ru.sberinvestor.core.state

enum class CodeState(val code: Int) {
    OK(200),
    CODE_401(401),
    NETWORK_ERROR(-1),
    UNKNOWN(-999);

    companion object {
        fun getItem(code: Int): CodeState {
            return when (code) {
                OK.code -> OK
                CODE_401.code -> CODE_401
                NETWORK_ERROR.code -> NETWORK_ERROR
                else -> {
                    UNKNOWN
                }
            }
        }
    }
}


