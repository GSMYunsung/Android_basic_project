package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityContacts2Binding
import com.example.myapplication.databinding.ActivityRecyclerViewBinding
import org.w3c.dom.Text

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        setContentView(R.layout.activity_recycler_view)

        val carList = ArrayList<CarForList>()
        for(i in 0 until 50){
            carList.add(CarForList("" + i + "번째 자동차", "" + i + "순위엔진"))
        }
        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))

        //어뎁터로 두 듀 Layout을 연결해주고, 레이아웃메니저에 넣어서 리사이클러뷰 관리

        //recycler_view.adapter= adapter
        //recycler_view.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)

    }
}

class RecyclerViewAdapter(
    val itemList : ArrayList<CarForList>,
    val inflater : LayoutInflater
    ): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carName : TextView
        val carEngin : TextView
        init {
            //그렇게 들어온 view에대해서 carName과 carEngin이 세팅된다.
            carName = itemView.findViewById(R.id.car_name)
            carEngin = itemView.findViewById(R.id.car_engine)
        }
    }

    //전체뷰를 가져올 수 있게 뷰그룹으로 타입을 지정해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //뷰를 이쪽에서 만들어준다.
        //먼저 xml파일을 view로 만들어주고, view를 creatviewHolder에 넣어준다.
        val view = inflater.inflate(R.layout.item_view, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //뷰의 사이즈
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //list 뷰 홀더
        //실질적으로 뷰를 그려준다.
        //위의 onCreateViewHolder에서 세팅해준 name 과 engine을 화면에 넣어준다.
        holder.carName.setText(itemList.get(position).name)
        holder.carEngin.setText(itemList.get(position).engine)
    }
}

