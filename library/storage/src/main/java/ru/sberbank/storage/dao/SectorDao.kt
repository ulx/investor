package ru.sberbank.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sberbank.storage.entity.SectorDb

@Dao
interface SectorDao {

    @Query("SELECT * from sector_table")
    fun getAlphabetizedWords(): List<SectorDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sectorDb: SectorDb) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: List<SectorDb>) : List<Long>

    @Query("DELETE FROM sector_table")
    suspend fun deleteAll()
}
