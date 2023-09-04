package com.my.contactpart.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.contactpart.ContactData
import com.my.contactpart.repository.ContactsRepository
import kotlinx.coroutines.launch


class ContactViewModel:ViewModel() {

    val contactRepo =ContactsRepository()
     fun saveContact(ContactData:ContactData){
         viewModelScope.launch {
             contactRepo.saveContact(ContactData)
         }

    }
    fun getContacts(): LiveData<List<ContactData>>{
        return contactRepo.getDbContacts()
    }
}