package com.nmt.roomdatabase.DATA

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nmt.roomdatabase.model.LoginModel


@Database(entities = [User::class], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO?

    companion object {
        private var database: com.nmt.roomdatabase.DATA.RoomDatabase?=null

        fun getDB(context: Context) : com.nmt.roomdatabase.DATA.RoomDatabase
        {
            if (database == null)
            {
                database= Room.databaseBuilder<com.nmt.roomdatabase.DATA.RoomDatabase>(context.applicationContext,com.nmt.roomdatabase.DATA.RoomDatabase::class.java,"database")
                    .allowMainThreadQueries()
                    .build()
            }
            return database as com.nmt.roomdatabase.DATA.RoomDatabase
        }
    }
}