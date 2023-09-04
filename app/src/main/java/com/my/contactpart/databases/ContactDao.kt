package com.my.contactpart.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.my.contactpart.ContactData

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: ContactData)
    @Query("SELECT * FROM contacts ORDER BY name")
    fun getAllContact(): LiveData<List<ContactData>>
    @Query("SELECT * FROM contacts WHERE  contactId =:contactId")
     fun getContactById(contactId: Int): LiveData<ContactData>

}
//context are the environmental and there is tow type of context is

//acrivity context:
//read more on memory led
//andriod contxtr
//globle context