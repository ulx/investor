package ru.sberbank.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "broker_table")
data class BrokerDb(
    @ColumnInfo(name = "brokerNameKey") val brokerNameKey: String = "",
    @PrimaryKey @ColumnInfo(name = "broker_id") val id: String = "",
    @ColumnInfo(name = "isActive") val isActive: Boolean = false,
    @ColumnInfo(name = "broker_name") val name: String = ""
)