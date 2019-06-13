package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            randomCard.setOnClickListener {View ->
                val intent = Intent(this, ResultActivity::class.java)
                intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
                startActivity(intent)
            }

            constellationCard.setOnClickListener {View ->
                startActivity(Intent(this, ConstellationActivity::class.java))
            }

            nameCard.setOnClickListener {View ->
                startActivity(Intent(this, NameActivity::class.java))
            }
        }
    }
