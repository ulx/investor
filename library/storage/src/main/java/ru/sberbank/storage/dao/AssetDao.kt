package ru.sberbank.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sberbank.storage.entity.AssetDb

@Dao
interface AssetDao {

    @Query("SELECT * from asset_table")
    suspend fun getAlphabetizedWords(): List<AssetDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: AssetDb) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: List<AssetDb>) : List<Long>

    @Query("DELETE FROM asset_table")
    suspend fun deleteAll()
}