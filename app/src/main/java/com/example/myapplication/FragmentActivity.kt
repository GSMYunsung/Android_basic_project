//package com.example.myapplication
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import androidx.fragment.app.FragmentManager
//
//// 화면관리
//
//class FragmentActivity : AppCompatActivity(), Fragment1.OnDataPassListener {
//
//    override fun OnDataPass(data: String?) {
//        Log.d("Pass","" + data)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_fragment)
//        Log.d("life_cycle", "F onCreate");
//
//        val Buttonn : Button = findViewById(R.id.buttonn)
//        val Buttonn2 : Button = findViewById(R.id.buttonn2)
//        val fragmentone : Fragment1 = Fragment1()
//        //프라그맨트에 data를 넣어주는 방법
//        val bundle : Bundle = Bundle()
//        bundle.putString("hello", "hello")
//        fragmentone.arguments = bundle
//
//        Buttonn.setOnClickListener {
//            //프라그먼트를 동적으로 작동하는 방법
//            //프라그맨트 붙이는 방법 replace/add
//            val fragmentManager : FragmentManager = supportFragmentManager
//
//            // Transaction
//            // 작업의 단위 -> 시작과 끝이 있다!
//            // Transaction을 시작하겠다!
//            val fragmentTransation = fragmentManager.beginTransaction()
//            fragmentTransation.replace(R.id.container, fragmentone)
//            fragmentTransation.commit()
//
//            //끝을 내는 방법
//            //commit -> 시간 될 때 해라 (조금더 안정적)
//            //commitnow -> 지금 당장 해라
//
//        }
//
//        Buttonn2.setOnClickListener {
//            //프라그맨트 remove/detach 하는 방법
//
//            //프라그맨트를 따로따로 다른 변수에 할당시켜주면 결국은 다른 요소가 되므로, 화면이 바뀌지 않는다.
//            //프라그맨트를 전역변수로 설정해 준다.
//
//            //remove : 프라그맨트를 재할당 시켜줄 수 있다.
//            //detach : 프라그맨트를 재할당 시켜줄 수 없다.
//            val fragmentManager = supportFragmentManager
//            val framentTransient = fragmentManager.beginTransaction()
//            framentTransient.detach(fragmentone)
//            //framentTransient.remove(fragmentone)
//            framentTransient.commit()
//        }
//    }
//
//        override fun onStart() {
//        super.onStart()
//        Log.d("life_cycle", "F onStart");
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("life_cycle", "F onResume");
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("life_cycle", "F onPause");
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("life_cycle", "F onStop");
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("life_cycle", "F onDestroy.");
//    }
//
//
//}