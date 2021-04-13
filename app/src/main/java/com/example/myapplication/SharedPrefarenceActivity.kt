package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivitySharedPrefarenceBinding
import com.example.myapplication.databinding.ActivityTabPagerBinding

//앱의 캐시와 데이터를 삭제하게되면 그때서야 저장되었던 값이 사라진다.

class SharedPrefarenceActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySharedPrefarenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefarence)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_prefarence)

        binding.lodeBtm.setOnClickListener{
            //Shared_Preference 에 값을 불러오는 방법

            val sharedpreference = getSharedPreferences("sp1",Context.MODE_PRIVATE)
            //값을 받아올때에는 값을 받아오지 못할경우 예외처리도 같이 해주어야한다.
            val value1 = sharedpreference.getString("hello","값을 받아오지못했습니다!")
            val value2 = sharedpreference.getString("goodbye","값을 받아오지못했습니다!")
            val user_value = sharedpreference.getString("user_value","값을 받아오지못했습니다!")

            Log.d("key-value","Value 1 : " + value1)
            Log.d("key-value","Value 2 : " + value2)
            Log.d("key-value","user_Value : " + user_value)
        }

        binding.saveBtm.setOnClickListener{

            //만약 값을 저장하는 부분을 지운다 하더라도 이미 값이 저장이 되어있기때문에 값을 받아올 수 있다.

            //  Shared_Preference 에 값을저장하는 방법
            val sharedPrefarence = getSharedPreferences("sp1",Context.MODE_PRIVATE)
            // 데이터를 넣어줄 수 있는것을 가져와야함 , Editer -> Shared prefarence 에서 가져온다.

            val editer : SharedPreferences.Editor = sharedPrefarence.edit()
            editer.putString("hello","안녕하세요")
            editer.putString("goodbye","안녕히가세요")
            editer.putString("user_value",binding.editText.getText().toString())

            // 아직 들어간것이 아닌 commit으로 넣어주어야 들어간다.
            editer.commit()
        }

        binding.deleteBtm.setOnClickListener {
            val sharedPrefarence = getSharedPreferences("sp1",Context.MODE_PRIVATE)
            val editer = sharedPrefarence.edit()
            editer.remove("hello")
            //값을 저장하기위해서는 항상 edit 후에 commit!!
            editer.commit()
        }

        binding.allDeleteBtm.setOnClickListener {
            val sharedPrefarence = getSharedPreferences("sp1",Context.MODE_PRIVATE)
            val editer = sharedPrefarence.edit()
            editer.clear()
            editer.commit()
        }

        //sp1 -> SharedPreference
        //       (Key_Value) -> "hello","안녕하세요"

        // 하지만 같은 Key 값에 값을 넣더라도 Preference 고유 이름이 다르므로 값이 겹치지 않는다.


        //  Mode
        // - MODE_PRIVATE : 생성한 application만 사용이 가능하다!
        // 주로 사용하진 않는다_ 다른앱들간의 상호작용이 필요할때 ex) 카카오톡의 경우 카카오페이 카카오게임

        // - MODE_WORLD_READBLE : 다른 application 에서 사용가능 -> 읽을 수만 있다.
        // - MODE_WORLD_WRITEBLE : 다른 application 에서 사용가능 -> 기록도 가능!
        // - MODE_WORLD_PROCESS : 이미 호출되어 사용중인지 호출
        // - MODE_APPEND : 기존 preference에 신규로 추가
    }
}