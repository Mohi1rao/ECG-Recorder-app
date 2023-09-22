package com.example.hisdemo

import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageAdapter(val requiredContext : Context, private val listLang : ArrayList<LanguageDetails>) : RecyclerView.Adapter<LanguageAdapter.viewHolder>() {

    class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val lang : TextView = itemView.findViewById(R.id.tvLang)
        val selector : View? = itemView.findViewById(R.id.llLangList)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_language_list,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return listLang.size
    }

    var selectedItemPosition = -1

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

//        holder.lang.text = listLang[position].language
//
//        holder.lang.setOnClickListener {
//
//            holder.selector?.setBackgroundColor(Color.GRAY)


        holder.lang.setText("${listLang.get(position).language} ")

        holder.lang.setOnClickListener{
            selectedItemPosition = position
            //this funcion reload the list whenever data changes
            notifyDataSetChanged()
        }

        if(selectedItemPosition == position) {
            holder.selector?.setBackgroundColor(Color.GRAY)
            holder.lang.setTextColor(Color.WHITE)
//            OnSelectLanguage.onSelectedLanguage(listLang.get(position))
        }
        else {
            holder.selector?.setBackgroundColor(Color.WHITE)
            holder.lang.setTextColor(Color.BLACK)
        }

        }

//    interface OnSelectLanguage{
//        fun onSelectedLanguage(selectedLanguage: String)
//
//    }

}
