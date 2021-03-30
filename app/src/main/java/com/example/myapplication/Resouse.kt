package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityResouseBinding
import com.example.myapplication.databinding.FragmentoneBinding
import com.example.myapplication.databinding.ResouseBinding


class Resouse : AppCompatActivity() {

    //바인딩 : xml코드를 layout으로 묶어주고 바인딩선언 및 바인딩에 값 할당.
    private lateinit var binding : ActivityResouseBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resouse)
        setContentView(R.layout.activity_resouse)


        //1.
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment : " + ment)

        //2.
        val ment2 = getString(R.string.hello)
        Log.d("ment","ment: " + ment)

        var color = getColor(R.color.red)
        Log.d("ment","color : " + color)

        binding.Button.setBackgroundColor(getColor(R.color.red))
    }
}