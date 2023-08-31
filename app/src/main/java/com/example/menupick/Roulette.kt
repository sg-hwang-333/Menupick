package com.example.menupick

import android.annotation.SuppressLint
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bluehomestudio.luckywheel.WheelItem
import com.example.menupick.databinding.ActivityRouletteBinding
import kotlin.random.Random

class Roulette : AppCompatActivity()
{
    //룰렛 변수 선언
    private lateinit var wheelItems:ArrayList<WheelItem>//리스트
    private lateinit var point: String
    //뷰 바인딩
    private lateinit var binding: ActivityRouletteBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityRouletteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //초기화
        wheelItems = ArrayList()

        //추가 버튼을 누를 이벤트 설정하기
        generateWheelItems()//휠에 들어갈 아이템 생성
        //점수판 타겟이 정해지면 발생하는 이벤트
        binding.roulette.setLuckyWheelReachTheTarget {
            //아이템 변수에 담기
            val wheelItem = wheelItems[point.toInt() - 1]
            val money = wheelItem.text
            Toast.makeText(applicationContext, money + "는 어떠신가요?", Toast.LENGTH_SHORT).show()
        }
        binding.spinBtn.setOnClickListener {
            val random: Random = Random
            point = (random.nextInt(6) + 1).toString() //1~6, exclusive 라서 +1 해줌
            binding.roulette.rotateWheelTo(point.toInt())//1-6까지의 숫자중 한곳에 포인트가 가르키게 됨
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun generateWheelItems()
    {
        val f1 = resources.getDrawable(R.drawable.baseline_food_bank_24)
        val f2 = resources.getDrawable(R.drawable.baseline_food_bank_24)
        val f3 = resources.getDrawable(R.drawable.baseline_food_bank_24)
        val f4 = resources.getDrawable(R.drawable.baseline_food_bank_24)
        val f5 = resources.getDrawable(R.drawable.baseline_food_bank_24)
        val f6 = resources.getDrawable(R.drawable.baseline_food_bank_24)
        val food1: Bitmap = drawableToBitmap(f1)
        val food2: Bitmap = drawableToBitmap(f2)
        val food3: Bitmap = drawableToBitmap(f3)
        val food4: Bitmap = drawableToBitmap(f4)
        val food5: Bitmap = drawableToBitmap(f5)
        val food6: Bitmap = drawableToBitmap(f6)


        wheelItems.add(WheelItem(Color.parseColor("#D1382C"), food1, "양식"))
        wheelItems.add(WheelItem(Color.parseColor("#AE1D00"), food2, "일식"))
        wheelItems.add(WheelItem(Color.parseColor("#990800"), food3, "디저트"))
        wheelItems.add(WheelItem(Color.parseColor("#7A0A00"), food4, "중식"))
        wheelItems.add(WheelItem(Color.parseColor("#821A0A"), food5, "분식"))
        wheelItems.add(WheelItem(Color.parseColor("#BB0D00"), food6, "한식"))
        //점수판에 데이터 넣기
        binding.roulette.addWheelItems(wheelItems)
    }


    private fun drawableToBitmap(_drawable: Drawable): Bitmap
    {
        if (_drawable is BitmapDrawable)//만약 인자로 받은 녀석이 비트맵 드로어블 형식이라면
        {
            return _drawable.bitmap//드로어블을 비트맵화 해서 반환
        }
        //드로어블의 width, height 를 가지고 비트맵을 생성
        val bitmap: Bitmap = Bitmap.createBitmap(
            _drawable.intrinsicWidth,
            _drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        //비트맵을 그릴 캔버스 준비
        val canvas: Canvas = Canvas(bitmap)
        _drawable.setBounds(0,0,canvas.width,canvas.height)
        _drawable.draw(canvas)//그림
        return bitmap
    }
}