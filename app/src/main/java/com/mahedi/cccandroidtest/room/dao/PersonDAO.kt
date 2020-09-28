package com.mahedi.cccandroidtest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahedi.cccandroidtest.service.model.Person

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

@Dao
interface PersonDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(estimate: Person)

    @Query("SELECT * FROM person WHERE id = :id")
    fun findEstimateById(id: String): Person
}