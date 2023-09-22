package com.example.hisdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hisdemo.databinding.ActivityMainRecordBinding

class RecordEcgActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding : ActivityMainRecordBinding
    var pId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_record)

        binding = ActivityMainRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()
        setData()
        setListners()
        back()

    }

    private fun init(){

        pId = intent.getStringExtra("PId").toString()

    }

    private fun back() {
        binding.toolbarR.title.text= ""
        binding.toolbarR.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back)
        binding.toolbarR.toolbar.setNavigationOnClickListener {

            if(binding.cbLock.isChecked){

            }else{

                finish()
            }

        }
    }

    private fun setListners() {
        binding.btnHis.setOnClickListener(this)

    }

    private fun setData() {


        var IdCur = binding.tvPId.text
        binding.tvPId.text = "$IdCur $pId "

    }

    override fun onClick(v: View?) {
        when(v) {

            binding.btnHis ->
            {

                if(binding.cbLock.isChecked){

                }else {
                    val intent = Intent(this, HistoryActivity::class.java)

                    intent.putExtra("PIdH", pId)

                    startActivity(intent)
                }

            }
        }
    }
}