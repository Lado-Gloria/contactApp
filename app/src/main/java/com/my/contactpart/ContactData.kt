package com.my.contactpart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class ContactData(
    @PrimaryKey(autoGenerate = true) var contactId: Int,
    var avatar: String,
    var contact: String,
    var email: String,
    var name: String
) {
    // No need to define the custom getter for contactId
    // The default getter generated by Kotlin will be used automatically
}
