package ru.sberbank.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country_table")
data class CountryDb(
    @ColumnInfo(name = "flag_url") val flag_url: String = "",
    @PrimaryKey @ColumnInfo(name = "country_id") val id: String = "",
    @ColumnInfo(name = "country_name") val name: String = ""
)