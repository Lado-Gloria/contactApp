package com.my.contactpart.repository

import androidx.lifecycle.LiveData
import com.my.contactpart.ContactData
import com.my.contactpart.ContactpartApp
import com.my.contactpart.databases.ContactDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database =ContactDb.getDatabase(ContactpartApp.appContext)
    suspend fun saveContact(ContactData: ContactData){
        withContext(Dispatchers.IO){
            database.contactDao().insert(contact = ContactData)
        }
    }
    fun getDbContacts():LiveData<List<ContactData>>{
        return  database.contactDao().getAllContact()
    }
}