package com.my.contactpart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.contactpart.databinding.ActivityMainBinding
import com.my.contactpart.models.ContactViewModel
import com.my.contactpart.ui.AddcontactActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contactViewModel: ContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


    override fun onResume() {
        super.onResume()

        // Observe changes in contact list
        contactViewModel.getContacts().observe(this, { contacts -> displayContact(contacts) })

        binding.btnbutton.setOnClickListener {
            val intent = Intent(this, AddcontactActivity::class.java)
            startActivity(intent)
        }


    }

    private fun displayContact(contactsList: List<ContactData>) {
        val contactAdapter = ContactrvAdapter(contactsList,this)
        binding.rvcontact.layoutManager =LinearLayoutManager(this)
        binding.rvcontact.adapter = contactAdapter
    }
}
