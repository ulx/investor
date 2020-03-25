package ru.sberbank.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sberbank.storage.entity.CountryDb

@Dao
interface CountryDao {

    @Query("SELECT * from country_table")
    fun getAlphabetizedWords(): List<CountryDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(countryDb: CountryDb)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: List<CountryDb>)

    @Query("DELETE FROM country_table")
    suspend fun deleteAll()
}