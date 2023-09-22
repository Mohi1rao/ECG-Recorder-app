package com.example.hisdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.hisdemo.databinding.ActivityMainStartBinding
import com.google.zxing.integration.android.IntentIntegrator

class EnterPatientIdActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding : ActivityMainStartBinding
    private var customerid = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_start)


        init()
        setData()
        setListners()
    }

    private fun init(){

        binding = ActivityMainStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customerid = intent.getStringExtra("CustomerId").toString()

    }

    private fun setListners() {
        binding.btnBarcode.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    private fun setData() {

        

    }

    override fun onClick(v: View?) {
        when(v) {

            binding.btnSubmit ->
            {
                val intent = Intent(this,RecordEcgActivity::class.java)

                var id = binding.etId.text.toString()

                intent.putExtra("PId", id)

                startActivity(intent)

            }
            binding.btnBarcode->{
                val scanner = IntentIntegrator(this)

                //for beep sound
                scanner.setBeepEnabled(false)

                scanner.initiateScan()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){

            val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
            if(result!= null){
                if(result.contents == null){
                    Toast.makeText(this,"cancelled",Toast.LENGTH_SHORT).show()
                }else{
//                    Toast.makeText(this,"scanned: " + result.contents,Toast.LENGTH_SHORT).show()
                    binding.etId.setText(result.contents)
                }
            }else{
                super.onActivityResult(requestCode,resultCode,data)
            }

        }
    }




}