package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Fragment2Binding
import com.example.myapplication.databinding.FragmentoneBinding


class Fragment_2 : Fragment(){
    private lateinit var binding : Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 프라그먼트가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater -> View를 그려주는 역할
        // container -> 부모 뷰, 즉, 프라그먼트가 어디에 그려질지 지정해줌.
        // Fragment가 activity보다 먼저 호출된다.
        Log.d("life_cycle", "onCreateView");
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_2,container,false)
        return binding.root
    }
}