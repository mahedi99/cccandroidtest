package com.mahedi.cccandroidtest.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mahedi.cccandroidtest.room.dao.EstimateDAO
import com.mahedi.cccandroidtest.service.model.Estimate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

class EstimateRepository(private val estimateDAO: EstimateDAO) {
    suspend fun insertEstimate(estimate: Estimate) {
        withContext(Dispatchers.IO) {
            estimateDAO.insert(estimate)
        }
    }

    fun findEstimateById(id: String): LiveData<Estimate> {
        return liveData(Dispatchers.IO){
            emit(estimateDAO.findEstimateDataById(id))
        }
    }
}