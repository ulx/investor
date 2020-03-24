package ru.sberbank.network.entity

data class Company(
    val basic_name: String = "",
    val company_desc: String = "",
    val country_id: String = "",
    val dividends_currencies: List<String> = emptyList(),
    val dividends_tracked: Boolean = false,
    val finparams_tracked: Boolean = false,
    val id: String = "",
    val image_full_size: String = "",
    val issue_size: Long,
    val logo_url: String,
    val logo_url_small: String,
    val main_instrument_id: String,
    val main_report_currency: String,
    val name: String,
    val news_tracked: Boolean,
    val reports_map: String,
    val sector_id: String,
    val url: String
)