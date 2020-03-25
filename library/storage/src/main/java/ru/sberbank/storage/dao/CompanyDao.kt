package ru.sberbank.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sberbank.storage.entity.CompanyDb

@Dao
interface CompanyDao {

    @Query("SELECT * from company_table")
    fun getAlphabetizedWords(): List<CompanyDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(companyDb: CompanyDb)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(assetDb: List<CompanyDb>)

    @Query("DELETE FROM company_table")
    suspend fun deleteAll()
}