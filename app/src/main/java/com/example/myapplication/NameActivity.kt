package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        goButton.setOnClickListener { view ->
            if (editText.text.toString().equals("")) {
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)

                intent.putIntegerArrayListExtra(
                    "result",
                    ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString()))
                )

                intent.putExtra("name", editText.text.toString())

                startActivity(intent)
            }
        }

        backButton.setOnClickListener { view ->
            finish();
        }
    }
}