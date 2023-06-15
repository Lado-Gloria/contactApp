package com.my.contactpart

import android.content.Intent
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


        binding.btnbutton.setOnClickListener {
            val intent = Intent(this, AddcontactActivity::class.java)
            startActivity(intent)
        }
    }

override fun onResume() {
    super.onResume()
    displayContact()
}
fun displayContact(){
    var contact1 =ContactData("https://media.istockphoto.com/id/1465453773/photo/portrait-of-pretty-dark-skin-wavy-millennial-girl-wearing-yellow-suit-in-glasses-with-a-big.jpg?s=1024x1024&w=is&k=20&c=fbHVpqBnPEzGRUYVyALDMXb0m2KMXiYr9G5pustIw0g=","+25477689540","silva@gmail.com","Silva")
    var contact2 =ContactData("https://media.istockphoto.com/id/1365997114/photo/outdoor-portrait-of-young-african-american-backpacker.jpg?s=2048x2048&w=is&k=20&c=dbbPhvRm3-FsGg3F5Mc8An7t9T6IT2lAQfRkgDdJxME=","+25477689540","silva@gmail.com","Gloria")
    var contact3 =ContactData("https://media.istockphoto.com/id/534308672/photo/beautiful-young-african-woman-laughing-outdoors.jpg?s=1024x1024&w=is&k=20&c=sqGRYt9UoDhsGZBLdFrvePTYxEwbK8-IhYq6tHr94HA=","+25477689540","silva@gmail.com","Lado")
    var contact4 =ContactData("https://media.istockphoto.com/id/501464170/photo/woman-at-venice-beach-california.jpg?s=1024x1024&w=is&k=20&c=BEDB75l7dHcP_oxHLrDKgsH_5c6BkWU2Pls-7TDjkKg=","+25477689540","silva@gmail.com","Apolo")
    var contact5 =ContactData("https://media.istockphoto.com/id/157293343/photo/hot-shades.jpg?s=1024x1024&w=is&k=20&c=a0pWrGnHhGFGkcWUinrN-EDeAIeKLHDWbcpWL8-P5Tk=","+25477689540","silva@gmail.com","Lalam")
    var contact6 =ContactData("https://media.istockphoto.com/id/180702947/photo/beautiful-african-american-woman-outside.jpg?s=1024x1024&w=is&k=20&c=F7OiQGU4PovTMm8WEI_zYuUfKB_eNxjCLNMdMrj9cig=","+25477689540","silva@gmail.com","Scovia")
    var contact7 =ContactData("https://media.istockphoto.com/id/180819974/photo/beautiful-african-american-woman-outside.jpg?s=1024x1024&w=is&k=20&c=JT8g-4l-ffcRQ375_D8S_pO0j2KVAHXogQNC15ILFhY=","+25477689540","silva@gmail.com","Mercy")
    var contact8 =ContactData("https://media.istockphoto.com/id/1408192388/photo/young-woman-wearing-sunglasses-outdoors.jpg?s=1024x1024&w=is&k=20&c=q22WrbmPy9vWhguamPIhW2uzahT1ZQxxSejPw87BPy0=","+25477689540","silva@gmail.com","Silva")
    var contact9 =ContactData("https://media.istockphoto.com/id/814982968/photo/portrait-of-african-woman-captured-at-the-seaside.jpg?s=1024x1024&w=is&k=20&c=o5197NfO7CD4ZSEtqgCEKQyKqnzAO-LaIWQGTYq5ZW8=","+25477689540","silva@gmail.com","Silva")
    var contact10 =ContactData("https://media.istockphoto.com/id/814985542/photo/portrait-of-an-african-woman.jpg?s=1024x1024&w=is&k=20&c=nwJC3lXETBh-g2d6-JHvzbhL23Z2UzoY4KlzehhGa8U=","+25477689540","silva@gmail.com","Silva")
    var contactList = listOf<ContactData>(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9,contact10)
    binding.rvcontact.layoutManager= LinearLayoutManager(this)
    var contactAdapter =ContactrvAdapter(contactList)
    binding.rvcontact.adapter =contactAdapter
}
}

class AddContactActivity {

}


