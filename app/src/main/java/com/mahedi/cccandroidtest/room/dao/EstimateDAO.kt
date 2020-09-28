package com.mahedi.cccandroidtest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahedi.cccandroidtest.service.model.Estimate

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

@Dao
interface EstimateDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(estimate: Estimate)

    @Query("SELECT e.id, e.company, e.address, e.number, e.revision_number, e.created_date, p3.first_name || ' ' || p3.last_name as created_by, p2.first_name || ' ' || p2.last_name as requested_by, p1.first_name || ' ' || p1.last_name as contact FROM estimate e " +
            "inner join person p1 on e.contact = p1.id " +
            "inner join person p2 on e.requested_by = p2.id " +
            "inner join person p3 on e.created_by = p2.id WHERE e.id = :id")
    suspend fun findEstimateDataById(id: String): Estimate
}