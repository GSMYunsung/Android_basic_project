package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityLibraryBinding
import com.example.myapplication.databinding.ActivityResouseBinding

class Library : AppCompatActivity() {
    private lateinit var binding : ActivityLibraryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_library)

        //공간을 꽉채움
        Glide.with(this@Library).load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fextmovie.com%2Ffreeboard%2F40869023&psig=AOvVaw2AxMguuaXWrdafA8eRSiv1&ust=1617363902621000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNidl5n83O8CFQAAAAAdAAAAABAI")
            .centerCrop()
            .into(binding.glide)
    }
}