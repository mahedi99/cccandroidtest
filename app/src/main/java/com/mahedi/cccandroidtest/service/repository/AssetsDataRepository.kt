package com.mahedi.cccandroidtest.service.repository

import com.mahedi.cccandroidtest.service.model.SchoolModel

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

class AssetsDataRepository(private val assetsDataSource: AssetsDataSource) {
    fun getSchoolDataFromAssets(): SchoolModel {
        return assetsDataSource.getSchoolData()
    }
}