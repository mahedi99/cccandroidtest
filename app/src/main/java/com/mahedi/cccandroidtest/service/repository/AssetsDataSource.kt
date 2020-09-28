package com.mahedi.cccandroidtest.service.repository

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.mahedi.cccandroidtest.service.model.SchoolModel
import java.io.IOException
import java.lang.Exception

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

//Source name of json data from asset folder
private const val SOURCE_FILE_NAME = "data.json"

class AssetsDataSource(private val context: Context) {

    /**
     * Process data after fetching data from local JSON file and finally return data
     * to the repository
     */
    fun getSchoolData(): SchoolModel {

            val jsonString: String = context.assets.open(SOURCE_FILE_NAME).bufferedReader().use {
                it.readText()
            }
            return GsonBuilder().create()
                .fromJson(jsonString, object : TypeToken<SchoolModel>() {
                }.type)

    }
}
