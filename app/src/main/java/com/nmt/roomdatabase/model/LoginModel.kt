package com.nmt.roomdatabase.model

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import com.nmt.roomdatabase.DATA.RoomDatabase
import com.nmt.roomdatabase.DATA.User

class LoginModel(app:Application) : AndroidViewModel(app) {

    var allUser:MutableLiveData<List<User>>
    private var listofUser= mutableListOf<User>()

    init {
        allUser= MutableLiveData()
    }

    fun getallUserObserver(): MutableLiveData<List<User>> {
        return allUser
    }

    fun isDatabaseEmpty() :Boolean
    {
        if (getListofUser().size==0)
            return true
        else
            return false
    }

    fun getListofUser(): MutableList<User> {
        val userDao=RoomDatabase.getDB(getApplication()).userDAO()
        listofUser= userDao?.getUserInfo()!!
        return listofUser
    }

    fun addUser(user: User)
    {
        val userDao=RoomDatabase.getDB(getApplication()).userDAO()
        userDao?.addUser(user)
        getAllUser()
    }

    fun updateUser(user: User)
    {
        val userDao=RoomDatabase.getDB(getApplication()).userDAO()
        userDao?.updateUser(user)
        getAllUser()
    }

    fun getAllUser()
    {
        val userdao=RoomDatabase.getDB(getApplication()).userDAO()
        val listOfUser=userdao?.getUserInfo()

        allUser.postValue(listOfUser)
    }
}