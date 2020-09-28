package com.mahedi.cccandroidtest.view.factory

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahedi.cccandroidtest.viewmodel.SchoolViewModel

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

class SchoolViewModelFactory(private val ctx: Application, private val estimateId: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SchoolViewModel::class.java)){
            return SchoolViewModel(ctx, estimateId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}