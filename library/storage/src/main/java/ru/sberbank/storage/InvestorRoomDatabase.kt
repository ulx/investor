package ru.sberbank.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.sberbank.storage.dao.*
import ru.sberbank.storage.entity.*

@Database(entities = [AssetDb::class, BrokerDb::class, CompanyDb::class, CountryDb::class, InstrumentDb::class, SectorDb::class], version = 1, exportSchema = false)
abstract class InvestorRoomDatabase : RoomDatabase() {

    abstract fun assetDao(): AssetDao
    abstract fun brokerDao(): BrokerDao
    abstract fun companyDao(): CompanyDao
    abstract fun countryDao(): CountryDao
    abstract fun instrumentDao(): InstrumentDao
    abstract fun sectorDao(): SectorDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var instance: InvestorRoomDatabase? = null

        fun getDatabase(context: Context): InvestorRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): InvestorRoomDatabase {
            return Room.databaseBuilder(context.applicationContext, InvestorRoomDatabase::class.java, DATABASE_NAME
            ).build()
        }
    }
}

private const val DATABASE_NAME = "investor-db"