package com.my.contactpart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.view.View.inflate
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ComplexColorCompat.inflate
import com.my.contactpart.databinding.ActivityAddcontactBinding
import com.my.contactpart.databinding.ActivityAddcontactBinding.inflate

class AddcontactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddcontactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddcontactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button1 = findViewById<Button>(R.id.btnSave)
        button1.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        onResume()
    }


    override fun onResume() {
        super.onResume()
        checkError()
        validateContacts()
    }

    fun checkError(){

        binding.tieFirstName.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilFirstName.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )

        binding.tieSecondName.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilSecondName.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
        binding.tiePhoneNumber.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPhoneNumber.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
        binding.tieEmail.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
    }
    fun validateContacts(){
        val name =binding. tieFirstName.text.toString()
        val contacts = binding.tieSecondName.text.toString()

        val email =binding. tieEmail.text.toString()

        var error = false
        if (name.isBlank()){
            binding. tieFirstName.error = "name is required"
            error = true
        }

        if (name.isBlank()){
            binding. tieSecondName.error = "name is required"
            error = true
        }

        if (contacts.isBlank()){
            binding.tiePhoneNumber.error = "contacts is required"
            error = true
        }

        if (email.isBlank()){
            binding.tieEmail.error = "Email is required"
            error = true
        }


        if (!error){
            Toast.makeText(this,"$name,$contacts, $email", Toast.LENGTH_LONG).show()
        }

    }

}