package com.example.tecnomainz.client

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ClientData::class], version = 1, exportSchema = false)
abstract class ClientRoom:RoomDatabase() {
    abstract fun clientDao ():ClientDao
    companion object{
        @Volatile
        private var INSTANSE : ClientRoom? = null
        fun getDatabase(context: Context):ClientRoom{
            return INSTANSE?: synchronized(this){
                val instance =Room.databaseBuilder(context,ClientRoom::class.java,"Client")
                    .allowMainThreadQueries().build()
                INSTANSE=instance
                instance
            }
        }
    }

}