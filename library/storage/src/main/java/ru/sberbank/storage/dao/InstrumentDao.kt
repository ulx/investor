package ru.sberbank.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sberbank.storage.entity.InstrumentDb

@Dao
interface InstrumentDao {

    @Query("SELECT * from instrument_table")
    fun getAlphabetizedWords(): List<InstrumentDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(instrumentDb: InstrumentDb)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: List<InstrumentDb>)

    @Query("DELETE FROM instrument_table")
    suspend fun deleteAll()
}