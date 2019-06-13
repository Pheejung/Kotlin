package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result")
        val name = intent.getStringExtra("name")
        val constellation = intent.getStringExtra("constellation")

        resultLabel.text = "랜덤으로 생성된\n로또번호입니다."

        if(!TextUtils.isEmpty(name)){
            resultLabel.text = "${name}님의 \n${SimpleDateFormat("yyyy년-MM월-dd일").format(Date())}\n로또 번호입니다."
        }

        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "${constellation}의 \n${SimpleDateFormat("yyyy년-MM월-dd일").format(Date())}\n로또 번호입니다."
        }

        // 전달받은 결과가 있는 경우에만 실행
        result?.let {
            // 결과에 맞게 로또 번호를 각 텍스트뷰에 업데이트한다.
            // 전달받은 결과는 정렬되어 있지않으므로 정렬해서 전달한다.
            updateLottoBall(result.sortedBy { it })
        }
    }

    fun updateLottoBall(result : List<Int>){
        if(result.size < 6)
            return

        textView01.text = "${result[0]}"
        textView02.text = "${result[1]}"
        textView03.text = "${result[2]}"
        textView04.text = "${result[3]}"
        textView05.text = "${result[4]}"
        textView06.text = "${result[5]}"
    }
}

