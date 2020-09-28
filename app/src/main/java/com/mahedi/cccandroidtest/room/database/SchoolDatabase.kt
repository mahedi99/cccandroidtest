package com.mahedi.cccandroidtest.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mahedi.cccandroidtest.room.dao.EstimateDAO
import com.mahedi.cccandroidtest.room.dao.PersonDAO
import com.mahedi.cccandroidtest.service.model.Estimate
import com.mahedi.cccandroidtest.service.model.Person

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

@Database(entities = [Person::class, Estimate::class], version = 1, exportSchema = false)
abstract class SchoolDatabase: RoomDatabase() {
    abstract val personDao: PersonDAO
    abstract val estimateDao: EstimateDAO

    companion object {

        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SchoolDatabase::class.java,
                        "school_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}