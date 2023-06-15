package com.my.contactpart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View.inflate
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ComplexColorCompat.inflate
import com.my.contactpart.databinding.ActivityAddcontactBinding
import com.my.contactpart.databinding.ActivityAddcontactBinding.inflate

class AddcontactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddcontactBinding
    lateinit var tvNames:TextView
    lateinit var tvPhone: TextView
    lateinit var tvmailadress:TextView
    lateinit var btnadbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddcontactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvNames = binding.tvNames
        tvPhone =binding.tvPhone
        tvmailadress =binding.tvemailadress
        btnadbutton =binding.btnadbutton

        btnadbutton.setOnClickListener {
            val name = tvNames.text.toString()
           val phone = tvPhone.text.toString()
           val email = tvmailadress.text.toString()

            if (name.isNotEmpty()&&phone.isNotEmpty()&& email.isNotEmpty()){
                Toast.makeText(this,"Contact added sucessfully",Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }

        }


    }
}

class ActivityAddcontactBinding {

}

