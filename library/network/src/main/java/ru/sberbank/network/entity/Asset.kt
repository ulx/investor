package ru.sberbank.network.entity

data class Asset(
    val currency: String = "",
    val id: String = "",
    val issuer_id: Int = 0,
    val type: String = ""
)