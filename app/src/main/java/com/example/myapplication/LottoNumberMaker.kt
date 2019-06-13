package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {

    fun getRandomLottoNumbers() : MutableList<Int>{
        val lottoNumbers = mutableListOf<Int>()

        for(i in 1 .. 6){
            var number = 0
            do{
                number = getRandomLottoNumber()
            }while (lottoNumbers.contains(number))

            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    fun getRandomLottoNumber() : Int {
        return Random().nextInt(45)+1
    }

    fun getShuffleLottoNumbers() : MutableList<Int>{
        //1 ~ 45번에 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        for(number in 1..45){
            list.add(number)
        }

        //리스트를 무작위로 섞음
        list.shuffle()

        //리스트를 앞에서부터 순서대로 6개를 짤라 결과를 반환
        return list.subList(0, 6)
    }

    fun getLottoNumbersFromHash(str : String) : MutableList<Int>{
        val list = mutableListOf<Int>()

        for(number in 1..45){
            list.add(number)
        }

        //SimpleDateFormat은 날짜의 시산값을 포맷화된 텍슽 형태로 바꿔주는 클래스
        //현재 Date의 yyyy-MM-dd 문자열과 str 문자열을 합친다.
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) +  str

        //리스트를 무작위로 섞음.
        //섞는 기준으로 Random(SEED)를 활용
        //SEED값은 전달받은 이름과 오늘의 해당하는 yyyy-MM-dd를 합친 문자열의 해시코드를 사용
        list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0, 6)
    }
}



