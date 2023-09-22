package com.example.hisdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hisdemo.databinding.ActivityCustomerIdBinding

class CustomerIdActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding : ActivityCustomerIdBinding
    private var  customerId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_id)

        binding = ActivityCustomerIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setData()
        setListners()
    }

    private fun init(){



    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSubmitCustId-> {

                customerId = binding.etCustomerId.text.toString()

                if(customerId == ""){

                }else {

                    val intent = Intent(this, EnterPatientIdActivity::class.java)

                    intent.putExtra("CustomerId",customerId)

                    startActivity(intent)
                }

            }
    }
}


    private fun setListners() {
        binding.btnSubmitCustId.setOnClickListener(this)
    }

    private fun setData() {
    }

}