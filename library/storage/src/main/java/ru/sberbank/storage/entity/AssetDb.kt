package ru.sberbank.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asset_table")
data class AssetDb(
    @ColumnInfo(name = "currency") val currency: String = "",
    @PrimaryKey @ColumnInfo(name = "asset_id") val id: String = "",
    @ColumnInfo(name = "issuer_id") val issuer_id: Int = 0,
    @ColumnInfo(name = "type") val type: String = ""
)