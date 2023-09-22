package com.example.hisdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hisdemo.webservice.retrofitclient.models.HistoryResponseData
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

class HistoryAdapter(private val dataList : ArrayList<HistoryResponseData>) : RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]



        var dateCur = currentItem.dateTime
        var timeCur = currentItem.dateTime

        var date = formatDate(dateCur)

        holder.date.text = date
//        holder.Bpm.text = currentItem.avgHeartRate
        var deter = addDeter(currentItem.determination)
        holder.deter.text = deter

        var time = formatTime(timeCur)

        holder.time.text = time
        holder.BpmNum.text = currentItem.avgHeartRate
    }

    private fun addDeter(determination: String): String? {

        var final = "Determintion: ".plus(determination)

        var finall = final.substring(0,14)+final.substring(14, 15).toUpperCase() + final.substring(15).toLowerCase()

        return finall
    }


    //formating time

    private fun formatTime(dateCur1: String): String? {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = inputFormat.parse(dateCur1)

//      Format for output ----
//        val dateFormat = SimpleDateFormat("dd MMM yyyy")
        val timeFormat = SimpleDateFormat("h:mm a")
//        val formattedDate = date?.let { dateFormat.format(it) }
        var formattedTime = date?.let { timeFormat.format(it) }

        return formattedTime
    }


    //


    //formating date

    private fun formatDate(dateCur: String): String? {

        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = inputFormat.parse(dateCur)
//        Format for output ----
        val dateFormat = SimpleDateFormat("dd MMM yyyy")
//        val timeFormat = SimpleDateFormat("h:mm a")
        val formattedDate = date?.let { dateFormat.format(it) }
//        var formattedTime = date?.let { timeFormat.format(it) }

        return formattedDate

    }

    //


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val date : TextView = itemView.findViewById(R.id.tvDate)
//        val Bpm : TextView = itemView.findViewById(R.id.tvBPM)
        val BpmNum : TextView = itemView.findViewById(R.id.tvBPMNum)
        val deter : TextView = itemView.findViewById(R.id.tvDetermination)
        val time : TextView = itemView.findViewById(R.id.tvtime)

    }

}