@file:Suppress("DEPRECATION")

package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.databinding.ActivityTabPagerBinding
import com.example.myapplication.databinding.FragmentoneBinding
import java.text.FieldPosition

class TabPagerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTabPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tab_pager)

        //탭의 개수를 지정할 수 있다.
        //AddTab에 새로운 Tab을 더해주어서 이름이 ONE인 새로운탭을 만들었다.
        binding.TabLayout.addTab(binding.TabLayout.newTab().setText("ONE"))
        binding.TabLayout.addTab(binding.TabLayout.newTab().setText("TWO"))
        binding.TabLayout.addTab(binding.TabLayout.newTab().setText("THREE"))
    }
}

// 어뎁터가 프레그먼트를 받아온다, 즉 Pager가 프레그먼트로 구성되어있다.
class PagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount:Int
): FragmentStatePagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        //아이템을 찾아서 리턴해준다.
        when(position){
            0 ->  {
                return Fragment_1()
            }
            1 ->  {
                return Fragment_2()
            }
            2 ->  {
                return Fragment_3()
            }
            else -> return Fragment_1()
        }
    }

    override fun getCount(): Int {
        //전체 크기를 리턴해준다. 즉. 페이지수를 리턴해준다.
        return tabCount
    }
}