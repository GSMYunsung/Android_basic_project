//package com.example.myapplication
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import androidx.databinding.DataBindingUtil
//import com.example.myapplication.databinding.ActivityResouseBinding
//import com.example.myapplication.databinding.ActivityThreadBinding
//
//private lateinit var binding : ActivityThreadBinding
//class ThreadActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_thread)
//        setContentView(R.layout.activity_thread)
//
//        val runnable : Runnable = object : Runnable{
//            override fun run() {
//                Log.d("thread-1", "Thread is made")
//            }
//        }
//
//        val thread : Thread = Thread(runnable)
//
//        binding.button.setOnClickListener {
//            thread.start()
//        }
//
//        //람다를 사용하지 않은 방식
//        Thread(object : Runnable{
//            override fun run() {
//                Log.d("thread-1", "Thread is made, 2")
//            }
//        }).start()
//
//        //람다를 사용한 방식
//        Thread(Runnable {
//            //다음과 같은경우, 메인쓰레드가 아닌 다른쓰레드가 UI를 건들었으므로 앱이 크래시가 난다.
////            Thread.sleep(2000)
////            Log.d("thread-1", "Thread is made, 3")
////            binding.button.setBackgroundColor(getColor(R.color.black))
//
//            //다음과같은경우, UI를 메인쓰레드에서 돌리게 설정 하였으므로 크래시가 나지 않는다.
//                Thread.sleep(2000)
//                Log.d("thread-1", "Thread is made, 3")
//            runOnUiThread {
//                binding.button.setBackgroundColor(getColor(R.color.black))
//            }
//        }).start()
//    }
//}