package com.example.hisdemo.webservice.retrofitclient

import com.example.hisdemo.webservice.retrofitclient.models.HistoryRequest
import com.example.hisdemo.webservice.retrofitclient.models.HistoryResponse
import retrofit2.Call
import retrofit2.http.*

interface API {

    @POST("http://aws-synex.jy.digital/synex/Api/getHistory.php")
    fun getHistory(@Body request:HistoryRequest):Call<HistoryResponse>
}