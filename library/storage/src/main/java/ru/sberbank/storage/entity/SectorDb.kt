package ru.sberbank.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sector_table")
data class SectorDb(
    @PrimaryKey @ColumnInfo(name = "sector_id") val id: String = "",
    @ColumnInfo(name = "sector_name") val name: String = ""
)