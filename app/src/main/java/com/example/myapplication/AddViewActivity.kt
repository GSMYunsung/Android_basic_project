package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        //아이템 리스트 준비
        val carList = ArrayList<CarForList>()
        for(i in 0 until 10){
            carList.add(CarForList(""+i+"번째 자동차", "" + i + "순위 엔진"))
        }

        // 틀이될 레이아웃 받아오기
        var container = findViewById<LinearLayout>(R.id.addview_container)
        // Xml의 뷰 객체를 생성 해서 사용하기 위함.
        val inflater = LayoutInflater.from(this@AddViewActivity)

        for (i in 0 until carList.size){
            // 위에서 만들어준 리스트 아이템을 각각의 뷰에 넣을 준비
            val itemView = inflater.inflate(R.layout.item_view, null)
            val CarNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carengineView = itemView.findViewById<TextView>(R.id.car_engine)

            //리스트에서 각각의 순서에 맞는 구성요소를 클래스에서 받아오기
            CarNameView.setText(carList.get(i).name)
            carengineView.setText(carList.get(i).engine)
            //addView로 보여지게 설정
            container.addView(itemView)
        }
    }
}

class CarForList(val name : String, val engine: String){

}