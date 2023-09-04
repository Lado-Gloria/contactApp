package com.my.contactpart.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.my.contactpart.ContactData
import com.my.contactpart.R
import com.my.contactpart.databases.ContactDb
import com.my.contactpart.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactDetailsBinding

    private var contactId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve contactId from intent
        contactId = intent.getIntExtra("CONTACT_ID", -1)

        // Load and display contact details
        if (contactId != -1) {
            val database = ContactDb.getDatabase(applicationContext)
            val contactDao = database.contactDao()

            val contactLiveData = contactDao.getContactById(contactId)
            contactLiveData.observe(this, Observer { contact ->
                if (contact != null) {
                    displayContactDetails(contact)
                }
            })
        } else {
            // Handle invalid contactId
        }
    }

    private fun displayContactDetails(contact: ContactData) {
        binding.apply {
            tvNamedetail.text = contact.name
            tvphonedetail.text = contact.contact
            tvemaildetail.text = contact.email

            // Load contact image using Picasso or any other image loading library
            // Picasso.get().load(contact.image).into(ivContactImage)
        }
    }
}


