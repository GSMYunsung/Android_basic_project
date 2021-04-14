package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityAsyncBinding
import com.example.myapplication.databinding.ActivitySharedPrefarenceBinding
import java.lang.Exception

class Async : AppCompatActivity() {
    private lateinit var binding : ActivityAsyncBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        var task : BackgrundAsyncTask? = null
        binding = DataBindingUtil.setContentView(this, R.layout.activity_async)

        binding.start.setOnClickListener {
            task = BackgrundAsyncTask(binding.progressber,binding.ment)
            task?.execute()
        }

        binding.stop.setOnClickListener {
            task?.cancel(true)
        }
    }
}

class BackgrundAsyncTask(
    val progressber :ProgressBar,
    val progresstext : TextView,
    var percent : Int = 0

    // 1. doInBackground
    // 2. onProgressUpdate
    // 3. onPostExecute
): AsyncTask<Int,Int,Int>(){

    // params -> doInBackgorund 에서 사용할 타입
    // progress -> OnProgressUpdate 에서 사용할 타입
    // result -> OnPostExectue 에서 사용할 타입

    override fun onPreExecute() {
        percent = 0
        progressber.setProgress(percent)
    }

    override fun doInBackground(vararg p0: Int?): Int {
        //완료가 되어 있는지 검사한다
       while (isCancelled() == false)
       {
           percent++
           if (percent>100){
               break
           }
           else{
               //onProgressUpdate 에 중간중간 값을 전달하기 위해서 함수를 써준다.
               publishProgress(percent)
           }

           //Async로 로딩이 되는 장면이 보여지게 하기위해 쓰레드를 강제로 잠재운다.
           try{
               Thread.sleep(100)
           }
           catch (e : Exception){
               e.printStackTrace()
           }
       }
        return percent
    }

    //중간중간 돈다.
    override fun onProgressUpdate(vararg values: Int?) {
        //업데이트 만약 들어오는 값이 null이라면 0을 넣어준다.
        progressber.setProgress(values[0] ?: 0)
        Log.i("test",values.toString())
        progresstext.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    //doinbackground 가 종료 되었을 때 리턴되는 값을 받아서 실
    override fun onPostExecute(result: Int?) {
        progresstext.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressber.setProgress(0)
        progresstext.setText("작업이 취소되었습니다!")
    }
}