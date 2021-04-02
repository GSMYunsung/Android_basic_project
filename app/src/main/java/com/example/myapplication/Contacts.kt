package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
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
    }
}