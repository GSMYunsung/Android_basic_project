package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityContactsBinding
import com.example.myapplication.databinding.ActivityResouseBinding
import org.w3c.dom.Text

class Contacts : AppCompatActivity() {
    private lateinit var binding1 : ActivityContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        binding1 = DataBindingUtil.setContentView(this, R.layout.activity_contacts)

        val Phonebook = ArrayList<PhonebookTyipe>()
        for(i in 0 until 10)
        {
            Phonebook.add(PhonebookTyipe(""+i + "님","010-6987-156"+i))
        }

        val container = findViewById<LinearLayout>(R.id.container)
        val infilter = LayoutInflater.from(this@Contacts)

        for(i in 0 until Phonebook.size){
            val itemView = infilter.inflate(R.layout.contacts_item, null)
            val NameView = itemView.findViewById<TextView>(R.id.name)
            val numberView = itemView.findViewById<TextView>(R.id.number)

            NameView.setText(Phonebook.get(i).name)
            numberView.setText(Phonebook.get(i).callnumber)
            //addView로 보여지게 설정
            container.addView(itemView)
        }
    }
}

class PhonebookTyipe(val name : String, val callnumber : String){

}