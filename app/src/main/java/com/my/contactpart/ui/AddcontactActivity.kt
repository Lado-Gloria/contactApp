package com.my.contactpart.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.my.contactpart.ContactData
import com.my.contactpart.R
import com.my.contactpart.databinding.ActivityAddcontactBinding
import com.my.contactpart.models.ContactViewModel

class AddcontactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddcontactBinding
    private val contactViewModel: ContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddcontactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            validateAndSaveContact()
        }
    }

    private fun validateAndSaveContact() {
        val name = binding.tieFirstName.text.toString()
        val contacts = binding.tieSecondName.text.toString()
        val email = binding.tieEmail.text.toString()

        var error = false
        if (name.isBlank()) {
            binding.tieFirstName.error = getString(R.string.name_is_required)
            error = true
        }

        if (contacts.isBlank()) {
            binding.tieSecondName.error = getString(R.string.names_is_required)
            error = true
        }

        if (contacts.isBlank()) {
            binding.tiePhoneNumber.error = getString(R.string.contacts_is_required)
            error = true
        }

        if (email.isBlank()) {
            binding.tieEmail.error = getString(R.string.email_is_required)
            error = true
        }

        if (!error) {
            val newContact = ContactData(contactId = 0, name = name, email = email, avatar = "", contact = "phone"
            )
            contactViewModel.saveContact(newContact)
            Toast.makeText(this, "Contact Saved", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
