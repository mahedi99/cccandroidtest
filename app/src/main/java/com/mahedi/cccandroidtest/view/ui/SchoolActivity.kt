package com.mahedi.cccandroidtest.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahedi.cccandroidtest.R

class SchoolActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = SchoolFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment, fragment)
            commit()
        }
    }
}