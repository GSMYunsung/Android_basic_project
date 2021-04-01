package com.example.myapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context : Context = this // 모든 클레스는 결국 Context의 자식클레스이기때문에 this를 할당 시켜줘도 무관하다.
        val applicationContext: Context = getApplicationContext() as Context
    }
}