package com.example.hisdemo.webservice.retrofitclient.models

import com.google.gson.annotations.SerializedName
//import java.sql.ClientInfoStatus

data class HistoryResponse(
    @SerializedName("status")
    var status: Int,
    @SerializedName("message")
    var message : String,
    @SerializedName("data")
    var data: List<HistoryResponseData>
)

data class HistoryResponseData(
    @SerializedName("_id")
    var id : Id,
    @SerializedName("customerId")
    var customer_id: String,
    @SerializedName("patientId")
    var patient_id: String,
    @SerializedName("determination")
    var determination: String,
    @SerializedName("pdfFileUrl")
    var pdflink: String,
    @SerializedName("averageHeartRate")
    var avgHeartRate: String,
    @SerializedName("dateTime")
    var dateTime : String
)


data class Id(
    @SerializedName("\$oid")
    var oid: String
)


