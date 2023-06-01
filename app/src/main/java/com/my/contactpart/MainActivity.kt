package com.my.contactpart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.contactpart.databinding.ActivityMainBinding
import com.my.contactpart.databinding.ContactlistBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

override fun onResume() {
    super.onResume()
    displayContact()
}
fun displayContact(){
    var contact1 =ContactData("","+25477689540","silva@gmail.com","Silva")
    var contact2 =ContactData("","+25477689540","silva@gmail.com","Gloria")
    var contact3 =ContactData("","+25477689540","silva@gmail.com","Lado")
    var contact4 =ContactData("","+25477689540","silva@gmail.com","Apolo")
    var contact5 =ContactData("","+25477689540","silva@gmail.com","Lalam")
    var contact6 =ContactData("","+25477689540","silva@gmail.com","Scovia")
    var contact7 =ContactData("","+25477689540","silva@gmail.com","Mercy")
    var contact8 =ContactData("","+25477689540","silva@gmail.com","Silva")
    var contact9 =ContactData("","+25477689540","silva@gmail.com","Silva")
    var contact10 =ContactData("","+25477689540","silva@gmail.com","Silva")
    var contactList = listOf<ContactData>(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9,contact10)
    binding.rvcontact.layoutManager= LinearLayoutManager(this)
    var contactAdapter =ContactrvAdapter(contactList)
    binding.rvcontact.adapter =contactAdapter
}
}
