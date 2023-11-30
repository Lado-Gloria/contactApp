package com.my.contactpart.ui

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import com.my.contactpart.ContactData
import com.my.contactpart.R
import com.my.contactpart.databinding.ActivityAddcontactBinding
import com.my.contactpart.models.ContactViewModel
import java.io.File

class AddcontactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddcontactBinding
    private val contactViewModel: ContactViewModel by viewModels()
    lateinit var photoFile: File

    var cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val takenPhoto = BitmapFactory.decodeFile(photoFile.
                absolutePath)
                binding.ivAvatar.setImageBitmap(takenPhoto)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddcontactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            validateAndSaveContact()
        }
        binding.ivAvatar.setOnClickListener{
            capturePhoto()
        }
    }
    private fun capturePhoto(){
        var photoIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile=getPhotoFile("photo_${System.currentTimeMillis()}")
        val fileUri = FileProvider.getUriForFile(this,"com.my.contactpart.provider",photoFile)
        photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)

        cameraLauncher.launch(photoIntent)

    }
   private fun getPhotoFile(fileName:String):File{
        val folder =getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var tempFile =File.createTempFile(fileName, ".jpeg",folder)
       return  tempFile
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
