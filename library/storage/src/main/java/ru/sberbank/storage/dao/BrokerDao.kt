package ru.sberbank.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sberbank.storage.entity.BrokerDb

@Dao
interface BrokerDao {

    @Query("SELECT * from broker_table")
    fun getAlphabetizedWords(): List<BrokerDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(brokerDb: BrokerDb)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: List<BrokerDb>)

    @Query("DELETE FROM broker_table")
    suspend fun deleteAll()
}