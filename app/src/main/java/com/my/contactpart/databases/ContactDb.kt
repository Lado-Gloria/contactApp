package com.my.contactpart.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.my.contactpart.ContactData

@Database(entities = arrayOf(ContactData::class), version = 1 )
 abstract class ContactDb:RoomDatabase() {
     abstract  fun contactDao(): ContactDao
     companion object{
         private var database:ContactDb? =null
         fun getDatabase(context:Context):ContactDb{
             if (database==null){
                 database  = Room
                     .databaseBuilder(context,ContactDb::class.java,"ContactDb")
                     .fallbackToDestructiveMigration()
                     .build()
             }
             return database as ContactDb
         }
//         find out static /companion object
//         abtract class
     }
}