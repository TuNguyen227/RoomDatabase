package com.nmt.roomdatabase.DATA

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_DATA")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "username") val username:String,
    @ColumnInfo(name = "password") val password:String
)
