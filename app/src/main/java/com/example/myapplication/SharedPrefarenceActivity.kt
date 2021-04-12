package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivitySharedPrefarenceBinding
import com.example.myapplication.databinding.ActivityTabPagerBinding

class SharedPrefarenceActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySharedPrefarenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefarence)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_prefarence)

        //  Shared_Preference
        val sharedPrefarence = getSharedPreferences("sp1",Context.MODE_PRIVATE)
        // 데이터를 넣어줄 수 있는것을 가져와야함 , Editer -> Shared prefarence 에서 가져온다.

        val editer : SharedPreferences.Editor = sharedPrefarence.edit()
        editer.putString("hello","안녕하세요")
        // 아직 들어간것이 아닌 commit으로 넣어주어야 들어간다.
        editer.commit()

        binding.button1

        //sp1 -> SharedPreference
        //       (Key_Value) -> "hello","안녕하세요"

        // 하지만 같은 Key 값에 값을 넣더라도 Preference 고유 이름이 다르므로 값이 겹치지 않는다.


        //  Mode
        // - MODE_PRIVATE : 생성한 application만 사용이 가능하다!
        // 주로 사용하진 않는다_ 다른앱들간의 상호작용이 필요할때 ex) 카카오톡의 경우 카카오페이 카카오게임

        // - MODE_WORLD_READBLE : 다른 application 에서 사용가능 -> 읽을 수만 있다.
        // - MODE_WORLD_WRITEBLE : 다른 application 에서 사용가능 -> 기록도 가능!
        // - MODE_WORLD_PROCESS : 이미 호출되어 사용중인지 호출
        // - MODE_APPEND : 기존 preference에 신규로 추
    }
}