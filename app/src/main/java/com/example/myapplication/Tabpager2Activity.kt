package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.databinding.ActivityTabPagerBinding
import com.google.android.material.tabs.TabLayout

class Tabpager2Activity : AppCompatActivity() {
    private lateinit var binding : ActivityTabPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tab_pager)

        binding.TabLayout.addTab(binding.TabLayout.newTab().setText("ONE"))
        binding.TabLayout.addTab(binding.TabLayout.newTab().setText("TWO"))
        binding.TabLayout.addTab(binding.TabLayout.newTab().setText("THREE"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this@Tabpager2Activity))

        binding.ViewPager.adapter = adapter
        binding.ViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.TabLayout))

        binding.TabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                //Tab이 다시 선택되었을때 행동
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                //Tab이 선택되었을 때 행동
                binding.ViewPager.currentItem = tab!!.position
            }
        })
    }
}
class ThreePageAdapter( val layoutinflater : LayoutInflater
): PagerAdapter(){

    //View 생성
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            0 -> {
                val view = layoutinflater.inflate(R.layout.fragmentone, container, false)
                container.addView(view)
                return view
            }
            1->{
                val view = layoutinflater.inflate(R.layout.fragment_2, container, false)
                container.addView(view)
                return view
            }
            2->{
                val view = layoutinflater.inflate(R.layout.fragment_3, container, false)
                container.addView(view)
                return view
            }
            else->{
                val view = layoutinflater.inflate(R.layout.fragmentone, container, false)
                container.addView(view)
                return view
            }

        }
    }

    //시스템이 판단해 뷰가 삭제될 일이 생기면 삭제한다.
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View) // 뷰를 컨테이에서 때어준다. Additem 반대로 생각하면 편함

    }

    //pager의 카운트 즉, 개수를 넣어준다
    override fun getCount(): Int {
        return 3
    }

    //View에 대한 생성여
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        // === : 보다 정확한 비교, 주소까지 비교한다.
        return view ===  `object` as View
    }

}
