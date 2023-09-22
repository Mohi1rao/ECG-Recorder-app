package com.example.hisdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hisdemo.databinding.ActivityLanguageBinding

class LanguageActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityLanguageBinding
    private var listLang = ArrayList<LanguageDetails>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setData()
        setListners()

    }

    private fun setListners() {
        binding.btnSmtLang.setOnClickListener(this)

    }

    private fun init() {

        listLang.add(LanguageDetails("中国人"))
        listLang.add(LanguageDetails("English"))
        listLang.add(LanguageDetails("한국인"))
        listLang.add(LanguageDetails("Español"))
        listLang.add(LanguageDetails("แบไทย"))

        binding.rcV.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.rcV.adapter = LanguageAdapter(this, listLang)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnSmtLang -> {

                val intent = Intent(this, CustomerIdActivity::class.java)

                startActivity(intent)

            }

        }
    }

    private fun setData() {


    }
}

