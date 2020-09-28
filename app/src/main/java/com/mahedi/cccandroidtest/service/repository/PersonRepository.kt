package com.mahedi.cccandroidtest.service.repository

import com.mahedi.cccandroidtest.room.dao.PersonDAO
import com.mahedi.cccandroidtest.service.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Mahedi Hassan
 * 2020-09-27
 */

class PersonRepository(private val personDAO: PersonDAO) {
    suspend fun insertPerson(person: Person) {
        withContext(Dispatchers.IO){
            personDAO.insert(person)
        }
    }
}