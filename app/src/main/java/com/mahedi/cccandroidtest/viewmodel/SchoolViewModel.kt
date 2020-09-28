package com.mahedi.cccandroidtest.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.mahedi.cccandroidtest.room.database.SchoolDatabase
import com.mahedi.cccandroidtest.service.model.Estimate
import com.mahedi.cccandroidtest.service.repository.AssetsDataRepository
import com.mahedi.cccandroidtest.service.repository.AssetsDataSource
import com.mahedi.cccandroidtest.service.repository.EstimateRepository
import com.mahedi.cccandroidtest.service.repository.PersonRepository
import kotlinx.coroutines.launch

/**
 * @author Mahedi Hassan
 * 2020-09-26
 */

class SchoolViewModel(application: Application, private val estimateId: String) : AndroidViewModel(application) {

    var result: LiveData<Estimate>
    private val estimateRepository: EstimateRepository
    private val personRepository: PersonRepository
    private val assetsDataRepository: AssetsDataRepository

    init {
        val assetsDataSource = AssetsDataSource(application)
        assetsDataRepository = AssetsDataRepository(assetsDataSource)
        val localDatabase = SchoolDatabase.getInstance(application)
        estimateRepository = EstimateRepository(localDatabase.estimateDao)
        personRepository = PersonRepository(localDatabase.personDao)

        viewModelScope.launch() {
            val data = assetsDataRepository.getSchoolDataFromAssets()

            estimateRepository.insertEstimate(data.estimate)
            personRepository.insertPerson(data.person)
        }
        result = estimateRepository.findEstimateById(estimateId)
    }
}