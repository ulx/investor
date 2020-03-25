package ru.sberbank.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "company_table")
data class CompanyDb(
    @ColumnInfo(name = "basic_name") val basic_name: String = "",
    @ColumnInfo(name = "company_desc") val company_desc: String = "",
    @ColumnInfo(name = "country_id") val country_id: String = "",
    @ColumnInfo(name = "dividends_tracked") val dividends_tracked: Boolean = false,
    @ColumnInfo(name = "finparams_tracked") val finparams_tracked: Boolean = false,
    @PrimaryKey @ColumnInfo(name = "company_id") val id: String = "",
    @ColumnInfo(name = "image_full_size") val image_full_size: String = "",
    @ColumnInfo(name = "issue_size") val issue_size: Long,
    @ColumnInfo(name = "logo_url") val logo_url: String,
    @ColumnInfo(name = "logo_url_small") val logo_url_small: String,
    @ColumnInfo(name = "main_instrument_id") val main_instrument_id: String,
    @ColumnInfo(name = "main_report_currency") val main_report_currency: String,
    @ColumnInfo(name = "company_name") val name: String,
    @ColumnInfo(name = "news_tracked") val news_tracked: Boolean,
    @ColumnInfo(name = "reports_map") val reports_map: String,
    @ColumnInfo(name = "sector_id") val sector_id: String,
    @ColumnInfo(name = "url") val url: String
)