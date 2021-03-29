package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafty : AppCompatActivity() {

    lateinit var latenumber : Nullclass

    class Nullclass(var number: Int){
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safty)

        val number : Int = 10
        val number1 : Int? = null

        val number5 : Int = number1!!+10 //null이 아니라는것을 개발자가 인증한다!

        //null이 아니면 더해줌
        val number3 = number1?.plus(number)
        //Log.d("number","number3 = " + number3)

        //삼항 연산자 -> 엘비스 연산자(?:)
        //NullSafty를 위한 도구
        val number4 = number1 ?: 10
        //Log.d("number","number4 = " + number4)

        latenumber = Nullclass(10)
        Log.d("number",""+latenumber.number)

//        앱 충돌이 일어난다!
//        Log.d("number",""+latenumber.number)
//        latenumber = Nullclass(10)
    }


    fun plus (a: Int, b : Int?) : Int{
        if(b != null) return a+b
        else return a
    }

    fun plus2(a: Int, b: Int?) : Int?{
        return b?.plus(a)
    }
}