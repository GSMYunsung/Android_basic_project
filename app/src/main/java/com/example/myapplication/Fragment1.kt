//package com.example.myapplication
//
//import android.content.Context
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.Fragment
//import com.example.myapplication.databinding.FragmentoneBinding
//
////fragment 관리 activity
//
//class Fragment1 : Fragment(){
//
//    interface OnDataPassListener{
//        fun OnDataPass(data : String?)
//    }
//
//    lateinit var dataPassListener : OnDataPassListener
//    private lateinit var binding : FragmentoneBinding
//
//    override fun onAttach(context: Context) {
//        Log.d("life_cycle", "onAttach.");
//
//        super.onAttach(context)
//        //형변환
//        dataPassListener = context as OnDataPassListener
//
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "onCreate")
//        super.onCreate(savedInstanceState)
//    }
//
//    //View를 그리는곳
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // 프라그먼트가 인터페이스를 처음으로 그릴 때 호출된다.
//        // inflater -> View를 그려주는 역할
//        // container -> 부모 뷰, 즉, 프라그먼트가 어디에 그려질지 지정해줌.
//        // Fragment가 activity보다 먼저 호출된다.
//        Log.d("life_cycle", "onCreateView");
//        binding = DataBindingUtil.inflate(inflater,R.layout.fragmentone,container,false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "onViewCreated");
//
//        //data binding
//        // FragMent -> Activity의 Oncreate에서 했던 작업을 여기에서 한다.
//        super.onViewCreated(view, savedInstanceState)
//        binding.pass.setOnClickListener {
//            dataPassListener.OnDataPass("Good Bye")
//        }
//
//
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "onActivityCreated");
//
//
////        // 하지만 XML에 ViewComponent로 추가한 부분을 주석을 풀면, 오류가발생한다.
////        // Why? 프라그먼트는 하나의 객체로 두개가 생성됐고, 여기에서 먼저 xml파일에 그려지는 객체가먼저 있는데
////        //      우리는 화면이 생성되자마자 data를 출력하라고했다. 하지만 data는 버튼을 클릭해야지만 할당이되기때문에 Null오류가 발생한다.
//        val data = arguments?.getString("hello")
//        Log.d("data",""+ data)
//        super.onActivityCreated(savedInstanceState)
//
//    }
//
//    override fun onStart() {
//        Log.d("life_cycle", "onStart");
//
//        super.onStart()
//
//    }
//
//    override fun onResume() {
//        Log.d("life_cycle", "onResume");
//
//        super.onResume()
//
//    }
//
//    override fun onPause() {
//        Log.d("life_cycle", "onPause");
//
//        super.onPause()
//
//    }
//
//    override fun onStop() {
//        Log.d("life_cycle", "onStop");
//
//        super.onStop()
//
//    }
//
//    override fun onDestroyView() {
//        Log.d("life_cycle", "onDestroyView");
//
//        super.onDestroyView()
//
//    }
//
//    override fun onDetach() {
//        Log.d("life_cycle", "onDetach");
//
//        super.onDetach()
//
//    }
//}