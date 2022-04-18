package com.nmt.roomdatabase.DATA

import androidx.room.*

@Dao
interface UserDAO {

    @Query("SELECT * FROM User_DATA ORDER by id ASC")
    fun getUserInfo(): MutableList<User>

    @Insert
    fun addUser(user: User?)

    @Delete
    fun removeUser(user: User?)

    @Update
    fun updateUser(user: User?)


}