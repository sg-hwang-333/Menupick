package com.example.menupick

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.TypedValue
import android.view.animation.Animation
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Best : AppCompatActivity() {
    lateinit var korFoodBtn: Button
    lateinit var japFoodBtn: Button
    lateinit var chiFoodBtn: Button
    lateinit var wesFoodBtn: Button
    lateinit var snackBtn: Button
    lateinit var dessertBtn: Button

    lateinit var foodTextView: TextView

    lateinit var addFAB: FloatingActionButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best)

        val searchView = findViewById<SearchView>(R.id.search_view)

        // 힌트 텍스트 스타일 변경
        val hintText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        hintText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f) // TextSize를 14dp로 설정
        hintText.setTextColor(Color.LTGRAY)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 검색 버튼을 눌렀을 때의 동작
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // 텍스트가 변경될 때의 동작
                if (newText.isNullOrEmpty()) {
                    // 텍스트가 비어있을 때, Hint 텍스트 색상을 다시 LTGRAY로 변경
                    hintText.setTextColor(Color.LTGRAY)
                } else {
                    // 텍스트가 입력될 때, 텍스트 색상을 BLACK으로 변경
                    hintText.setTextColor(Color.BLACK)
                }
                return true
            }
        })

//        foodTextView = findViewById(R.id.foodText)
//        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
//        radioGroup.setOnCheckedChangeListener{ group, checkedId ->
//            when(checkedId){
//                R.id.korFoodBtn -> foodTextView.text =  "한식"
//                R.id.japFoodBtn -> foodTextView.text =  "일식"
//                R.id.chiFoodBtn -> foodTextView.text =  "중식"
//                R.id.wesFoodBtn -> foodTextView.text =  "양식"
//                R.id.snackBtn -> foodTextView.text =  "분식"
//                R.id.dessertBtn -> foodTextView.text =  "디저트"
//            }
//        }
        foodTextView = findViewById<TextView>(R.id.foodText)

        val foodTextView = findViewById<TextView>(R.id.foodText)
        val korFoodBtn = findViewById<RadioButton>(R.id.korFoodBtn)
        val japFoodBtn = findViewById<RadioButton>(R.id.japFoodBtn)
        val chiFoodBtn = findViewById<RadioButton>(R.id.chiFoodBtn)
        val wesFoodBtn = findViewById<RadioButton>(R.id.wesFoodBtn)
        val snackBtn = findViewById<RadioButton>(R.id.snackBtn)
        val dessertBtn = findViewById<RadioButton>(R.id.dessertBtn)

        val radioButtons = listOf(korFoodBtn, japFoodBtn, chiFoodBtn, wesFoodBtn, snackBtn, dessertBtn)
        var selectedRadioButton: RadioButton? = null // 선택된 라디오 버튼을 추적하기 위한 변수

        korFoodBtn.background = getDrawable(R.drawable.selected_background)
        selectedRadioButton = korFoodBtn
        foodTextView.text = "한식"


        for (radioButton in radioButtons) {
            radioButton.setOnClickListener {
                // 이전에 선택되었던 라디오 버튼의 배경과 텍스트 색상을 원래대로 변경
                selectedRadioButton?.apply {
                    background = getDrawable(R.drawable.unselected_background)
                    setTextColor(ContextCompat.getColor(this@Best, R.color.black_400)) // 검은색으로 변경
                }

                // 현재 클릭한 라디오 버튼을 선택 상태로 변경
                radioButton.background = getDrawable(R.drawable.selected_background)
                radioButton.setTextColor(ContextCompat.getColor(this@Best, android.R.color.white)) // 흰색으로 변경
                selectedRadioButton = radioButton // 선택된 라디오 버튼 업데이트

                when (radioButton.id) {
                    R.id.korFoodBtn -> foodTextView.text = "한식"
                    R.id.japFoodBtn -> foodTextView.text = "일식"
                    R.id.chiFoodBtn -> foodTextView.text = "중식"
                    R.id.wesFoodBtn -> foodTextView.text = "양식"
                    R.id.snackBtn -> foodTextView.text = "분식"
                    R.id.dessertBtn -> foodTextView.text = "디저트"
                }
            }
        }



//        add food
        addFAB = findViewById(R.id.idFABAdd)
        addFAB.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            startActivity(intent)
        }


        //  Bottom bar
        val foodhomebutton : Button = findViewById(R.id.bar_foodBtn)
        foodhomebutton.setOnClickListener {
            val intent = Intent(this, FoodHome::class.java)
            startActivity(intent)
        }
        val roulettebutton : Button = findViewById(R.id.bar_rouletteBtn)
        roulettebutton.setOnClickListener {
            val intent = Intent(this, Roulette::class.java)
            startActivity(intent)
        }


    }
}