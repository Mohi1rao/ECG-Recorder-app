package com.example.hisdemo.webservice.retrofitclient.models


data class HistoryRequest(
    val customerId:String,
    val patientId:String,
    val determination: List<String>,
    val startDate:String?,
    val endDate:String?
)