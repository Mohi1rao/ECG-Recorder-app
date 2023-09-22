package com.example.hisdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hisdemo.databinding.ActivityMain2Binding
import com.example.hisdemo.webservice.retrofitclient.RetrofitClient
import com.example.hisdemo.webservice.retrofitclient.models.HistoryRequest
import com.example.hisdemo.webservice.retrofitclient.models.HistoryResponse
import com.example.hisdemo.webservice.retrofitclient.models.HistoryResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HistoryActivity : AppCompatActivity() {

    private  val TAG = "MainActivity2"
    private lateinit var newRecyclerview : RecyclerView
    var list = ArrayList<String>()
    private  var newArrayList =  ArrayList<HistoryResponseData> ()
    private lateinit var adapter:HistoryAdapter
    private var startDt = ""
    private var pId = ""

    var endDt = String()

//    lateinit var list : ArrayList<String>


    private lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        init()
        getUserdata()



    }

    override fun onSupportNavigateUp(): Boolean {
        return   super.onSupportNavigateUp()
    }


     private fun init() {

         RetrofitClient.setUpRetrofitClient(this@HistoryActivity)


         //get put Data

         intent.getStringArrayListExtra("USER")?.let {
             list = it

//              callApi()
         }

         intent.getStringExtra("startDt")?.let{

             startDt = it

//             callApi()
         }

         intent.getStringExtra("PID..")?.let{
             pId = it
         }




         intent.getStringExtra("PIdH")?.let {

             pId = it

             Log.d("PId", pId)

             //callApi()

         }



         intent.getStringExtra("endDt")?.let{
             endDt = it

             //  callApi()
         }

         callApi()

         //

         binding = ActivityMain2Binding.inflate(layoutInflater)
         setContentView(binding.root)

         binding.toolbar0.btnFilters.setOnClickListener {
             val intent = Intent(this, FiltersListActivity::class.java)
             intent.putExtra("USER1", list);

             intent.putExtra("startDt",startDt)
             intent.putExtra("endDt",endDt)
             intent.putExtra("PID.",pId)

             startActivity(intent)
             //finish()
         }


         binding.toolbar0.btnFilters.visibility = View.VISIBLE
         binding.toolbar0.title.text= "History"

         binding.toolbar0.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back)
         binding.toolbar0.toolbar.setNavigationOnClickListener {

             finish()

         }






         binding.recyclerView.layoutManager = LinearLayoutManager(this)
         binding.recyclerView.setHasFixedSize(true)



     }
    private fun getUserdata() {

         adapter = HistoryAdapter(newArrayList)

        binding.recyclerView.adapter = adapter

    }


    fun callApi(){
        val historyRequest =HistoryRequest(

//            synex-thailand
            customerId = "synex-thailand",
            patientId = pId,
            determination = list,
            startDate = startDt,
            endDate = endDt
        
        )
        Log.d("deter", historyRequest.toString())

//        Toast.makeText(this,startDt,Toast.LENGTH_SHORT).show()

        Log.d("Date",startDt)

        
        RetrofitClient.get().getHistory(historyRequest).enqueue(object:Callback<HistoryResponse>{
            override fun onResponse(
                call: Call<HistoryResponse>,
                response: Response<HistoryResponse>
            ) {
                if(response.isSuccessful){
                    newArrayList.clear()
                    newArrayList.addAll(response.body()?.data?:ArrayList<HistoryResponseData>())
                    adapter.notifyDataSetChanged()
                }else{

                    Log.e(TAG, "onResponse: ${response.errorBody()}" )

                }

            }

            override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ",t )
            }

        })
    }


}


