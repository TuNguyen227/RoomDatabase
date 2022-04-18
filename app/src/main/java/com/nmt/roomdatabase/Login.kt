package com.nmt.roomdatabase

import android.app.ActionBar
import android.app.Application
import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginStart
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.nmt.roomdatabase.DATA.RoomDatabase
import com.nmt.roomdatabase.DATA.User
import com.nmt.roomdatabase.databinding.FragmentLoginBinding
import com.nmt.roomdatabase.model.LoginModel


class Login : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        viewModel=ViewModelProvider(this).get(LoginModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnsave.setOnClickListener {
            val username=binding.editTextname.text.toString()
            val password=binding.editpassword.text.toString()
            viewModel.addUser(User(0,username,password))
        }

        binding.btnload.setOnClickListener {
            val listofUser=viewModel.getListofUser()
            var previewLayout=binding.PreviewAccountLayout
            previewLayout.orientation=LinearLayout.VERTICAL
            previewLayout.removeAllViews()

            if (!viewModel.isDatabaseEmpty())
            {
                for (user:User in listofUser)
                {
                    var previewAccountLayout=LinearLayout(context)
                    var textsize=25f
                    var param=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                    param.setMargins(20,0,0,0)
                    previewAccountLayout.orientation=LinearLayout.HORIZONTAL
                    var PreviewId=TextView(context)
                    var PreviewName=TextView(context)
                    var PreviewPassword=TextView(context)
                    PreviewId.setBackgroundResource(R.drawable.box_custom)
                    PreviewId.setText(user.id.toString())
                    PreviewId.textSize=textsize
                    PreviewName.setText(user.username)
                    PreviewName.layoutParams=param
                    PreviewName.textSize=textsize
                    PreviewName.setBackgroundResource(R.drawable.box_custom)
                    PreviewPassword.setText(user.password)
                    PreviewPassword.setBackgroundResource(R.drawable.box_custom)
                    PreviewPassword.layoutParams=param
                    PreviewPassword.textSize=textsize
                    previewAccountLayout.addView(PreviewId)
                    previewAccountLayout.addView(PreviewName)
                    previewAccountLayout.addView(PreviewPassword)
                    previewLayout.addView(previewAccountLayout)
                }
            }



        }
    }

}