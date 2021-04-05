package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityContacts2Binding
import com.example.myapplication.databinding.ActivityContactsBinding

class Contacts_2 : AppCompatActivity() {
    private lateinit var binding1 : ActivityContacts2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = DataBindingUtil.setContentView(this, R.layout.activity_contacts_2)
        getPersonAndDraw()
        binding1.back.setOnClickListener {
            binding1.manName.text = "fuck"
        }
    }
    private fun getPersonAndDraw(){
        val name : String = intent.getStringExtra("name")
        val number : String = intent.getStringExtra("number")

        binding1.manName.text = name
        binding1.manNum.text = number
    }
}