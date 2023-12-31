package com.example.menupick

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import com.google.android.flexbox.FlexboxLayout

class AddFood : AppCompatActivity()  {

    private val SELECT_IMAGE_REQUEST_CODE = 1
    private lateinit var imageView: ImageView
    private lateinit var editTextHashtag: EditText
    private lateinit var buttonSaveHashtag: Button
    private lateinit var hashtagsContainer: FlexboxLayout
    private val savedHashtags = mutableListOf<String>()

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        imageView = findViewById(R.id.imageView)
        val selectImageButton = findViewById<LinearLayout>(R.id.bring_picture)

        selectImageButton.setOnClickListener {
            // 갤러리에서 이미지를 선택하는 인텐트 시작
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
        }
        editTextHashtag = findViewById(R.id.editTextHashtag)
        buttonSaveHashtag = findViewById(R.id.buttonSaveHashtag)
        hashtagsContainer = findViewById(R.id.hashtagsContainer)

        buttonSaveHashtag.setOnClickListener {
            val hashtag = editTextHashtag.text.toString().trim()
            if (hashtag.isNotEmpty()) {
                savedHashtags.add("#$hashtag")
                updateSavedHashtags()
                editTextHashtag.text.clear()
            }
        }

        val countrySpinner: Spinner = findViewById(R.id.countrySpinner)
        val arrowIcon: ImageView = findViewById(R.id.arrowIcon)

        // 언어 목록 배열 정의
        val countries = arrayOf("한식", "일식", "중식", "양식", "분식", "디저트")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySpinner.adapter = adapter

        // Spinner 아이콘을 설정
        arrowIcon.setImageResource(R.drawable.baseline_arrow_drop_down_24)

        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               // 선택됐을때 처리
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 아무것도 선택되지 않았을 때 처리
            }
        }

        val backBest : ImageView = findViewById(R.id.before_btn)
        backBest.setOnClickListener {
            val intent = Intent(this, Best::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            val selectedImageUri = data.data
            val inputStream = contentResolver.openInputStream(selectedImageUri!!)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageView.setImageBitmap(bitmap)
        }
    }
    private fun updateSavedHashtags() {
        hashtagsContainer.removeAllViews() // 기존 해시태그 목록을 모두 제거

        for (savedHashtag in savedHashtags) {
            val hashtagTextView = TextView(this)
            hashtagTextView.text = savedHashtag
            hashtagTextView.setBackgroundResource(R.drawable.add_hash_bg)
            hashtagTextView.setTextColor(Color.BLACK) // 텍스트 색상 설정
            hashtagTextView.setPadding(16, 8, 16, 8) // 패딩 설정

            val layoutParams = FlexboxLayout.LayoutParams(
                FlexboxLayout.LayoutParams.WRAP_CONTENT,
                FlexboxLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.marginEnd = 16 // MarginRight 설정
            layoutParams.topMargin = 16
            hashtagTextView.layoutParams = layoutParams

            hashtagsContainer.addView(hashtagTextView)
        }
    }

}
