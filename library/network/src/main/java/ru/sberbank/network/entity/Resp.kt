package ru.sberbank.network.entity

data class Resp(
    val assets: List<Asset> = emptyList(),
    val brokers: List<Broker> = emptyList(),
    val companies: List<Company> = emptyList(),
    val countries: List<Country> = emptyList(),
    val instruments: List<Instrument> = emptyList(),
    val sectors: List<Sector> = emptyList(),
    val withAllInstruments: Boolean = false
)