package com.example.hisdemo

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.hisdemo.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class FiltersListActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var binding : ActivityMainBinding
    val list = arrayListOf<String>()
    var startDt1 = ""
    var endDt1 =""
    var pid = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()
        setData()
        setListners()
        dtPicker()
        back()

//sharedPreferances ka h ye bhi        loadData()
        //
//                btn = findViewById(R.id.btnApply)

//        btn.setOnClickListener {
//            finish()
//        }
    }

    private fun init(){

        intent.getStringExtra("startDt")?.let{

            startDt1 = it

        }


        intent.getStringExtra("endDt")?.let{
            endDt1 = it
        }

        intent.getStringExtra("PID.")?.let{
            pid = it
        }

    }

    private fun back() {
        val list = intent.getStringArrayListExtra("USER1")

        if (list != null) {
            if (list.size != 0){

               // var name = ""

                for (i in list){
                   if(i == "0"){
                       binding.cbNormal.toggle()
                   }
                    if(i == "1"){
                        binding.cbAfib.toggle()
                    }
                    if(i == "3"){
                        binding.cbTachycardia.toggle()
                    }
                    if(i == "4"){
                        binding.cbBradycardia.toggle()
                    }
                    if(i == "2"){
                        binding.cbUnclassified.toggle() }
                    if(i == "7"){
                        binding.cbUnreadable.toggle()
                    }
                    if(i == "5"){
                        binding.cbshort.toggle()
                    }
                    if(i == "6"){
                        binding.cblong.toggle()
                    }
                    if(i == "8"){
                        binding.cbNonalysis.toggle()
                    }

                }

            }
        }
    }
//SHARED Preferances
//    private fun saveData() {
//        val insertedTextFrom = binding.etFrom.text.toString()
//        val insertedTextTo = binding.etTo.text.toString()
//
//        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//
//        editor.apply{
//            putString("STRING_KEY", insertedTextFrom)
//
//            putString("STRING_KEY1", insertedTextTo)
//            putBoolean("BOOLEAN_KEY", binding.cbNormal.isChecked)
//            putBoolean("BOOLEAN_KEY1", binding.cbAfib.isChecked)
//            putBoolean("BOOLEAN_KEY2", binding.cbTachycardia.isChecked)
//            putBoolean("BOOLEAN_KEY3", binding.cbBradycardia.isChecked)
//            putBoolean("BOOLEAN_KEY4", binding.cbUnclassified.isChecked)
//            putBoolean("BOOLEAN_KEY5", binding.cbUnreadable.isChecked)
//        }.apply()
//
//    }
//
//    private fun loadData() {
//        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
//        val savedString = sharedPreferences.getString("STRING_KEY",null)
//        val savedString1 = sharedPreferences.getString("STRING_KEY1",null)
//        val savedBoolean= sharedPreferences.getBoolean("BOOLEAN_KEY",false)
//        val savedBoolean1= sharedPreferences.getBoolean("BOOLEAN_KEY1",false)
//        val savedBoolean2= sharedPreferences.getBoolean("BOOLEAN_KEY2",false)
//        val savedBoolean3= sharedPreferences.getBoolean("BOOLEAN_KEY3",false)
//        val savedBoolean4= sharedPreferences.getBoolean("BOOLEAN_KEY4",false)
//        val savedBoolean5= sharedPreferences.getBoolean("BOOLEAN_KEY5",false)
//
//        binding.etFrom.text = savedString
//        binding.etTo.text = savedString1
//        binding.cbNormal.isChecked = savedBoolean
//        binding.cbAfib.isChecked = savedBoolean1
//        binding.cbUnreadable.isChecked = savedBoolean5
//        binding.cbUnclassified.isChecked = savedBoolean4
//        binding.cbTachycardia.isChecked = savedBoolean2
//        binding.cbBradycardia.isChecked = savedBoolean3
//    }

//yaha tk

    private fun dtPicker() {

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)

        }

        val myCalendar0 = Calendar.getInstance()

        val datePicker0 = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar0.set(Calendar.YEAR, year)
            myCalendar0.set(Calendar.MONTH, month)
            myCalendar0.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable0(myCalendar0)

        }

        binding.etTo.setOnClickListener {
            DatePickerDialog(this,datePicker0,myCalendar0.get(Calendar.YEAR),myCalendar0.get(Calendar.MONTH),
                myCalendar0.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.etFrom.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

    }

    private fun setListners(){

        binding.btnReset.setOnClickListener(this)
        binding.btnApply.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when(v){
            binding.btnReset->{

                if(binding.cbNormal.isChecked()){

                    binding.cbNormal.toggle()

                }
                if(binding.cbAfib.isChecked()){

                    binding.cbAfib.toggle()

                }
                if(binding.cbBradycardia.isChecked()){

                    binding.cbBradycardia.toggle()

                }
                if(binding.cbTachycardia.isChecked()){

                    binding.cbTachycardia.toggle()

                }
                if(binding.cbUnclassified.isChecked()){

                    binding.cbUnclassified.toggle()

                }
                if(binding.cbUnreadable.isChecked()){

                    binding.cbUnreadable.toggle()

                }
                if(binding.cbshort.isChecked()){

                    binding.cbshort.toggle()

                }
                if(binding.cblong.isChecked()){

                    binding.cblong.toggle()

                }
                if(binding.cbNonalysis.isChecked()){

                    binding.cbNonalysis.toggle()

                }
                binding.etFrom.text = null
                binding.etTo.text = null

                //code for sharedpreferences

//                val insertedTextFrom = binding.etFrom.text.toString()
//                val insertedTextTo = binding.etTo.text.toString()
//
//                val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//                val editor = sharedPreferences.edit()
//
//                editor.apply{
//                    putString("STRING_KEY", insertedTextFrom)
//
//                    putString("STRING_KEY1", insertedTextTo)
//                    putBoolean("BOOLEAN_KEY", binding.cbNormal.isChecked)
//                    putBoolean("BOOLEAN_KEY1", binding.cbAfib.isChecked)
//                    putBoolean("BOOLEAN_KEY2", binding.cbTachycardia.isChecked)
//                    putBoolean("BOOLEAN_KEY3", binding.cbBradycardia.isChecked)
//                    putBoolean("BOOLEAN_KEY4", binding.cbUnclassified.isChecked)
//                    putBoolean("BOOLEAN_KEY5", binding.cbUnreadable.isChecked)
//                }.apply()

                //yaha tk

            }
            binding.btnApply->{

//hared Pref                saveData()

                if(binding.cbNormal.isChecked){
                    list.add("0")
                }
                if(binding.cbAfib.isChecked){
                    list.add("1")
                }
                if(binding.cbUnclassified.isChecked){
                    list.add("2")
                }
                if(binding.cbUnreadable.isChecked){
                    list.add("7")
                }
                if(binding.cbTachycardia.isChecked){
                    list.add("3")
                }
                if(binding.cbBradycardia.isChecked){
                    list.add("4")
                }
                if(binding.cbshort.isChecked){
                    list.add("5")
                }
                if(binding.cblong.isChecked){
                    list.add("6")
                }
                if(binding.cbNonalysis.isChecked){
                    list.add("8")
                }


                var startDt = binding.etFrom.text.toString()
                var endDt = binding.etTo.text.toString()

                val intent = Intent(this,HistoryActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)


                intent.putExtra("USER", list);
                intent.putExtra("startDt",startDt)
                intent.putExtra("endDt",endDt)
                intent.putExtra("PID..",pid)
                startActivity(intent)

                finish()

            }
        }
    }


    private fun setData(){

        binding.toolbar.title.text= "Filters"
        binding.toolbar.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back)
        binding.toolbar.toolbar.setNavigationOnClickListener {

            finish()

        }

        if(startDt1!= null){
            binding.etFrom.text = startDt1
        }

        if(endDt1!= null){
            binding.etTo.text = endDt1
        }

    }

    private fun updateLable0(myCalendar0: Calendar) {
        val myFormat0 = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat0, Locale.US)

        binding.etTo.setText(sdf.format(myCalendar0.time))

    }

    private fun updateLable(myCalendar: Calendar) {

        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        binding.etFrom.setText(sdf.format(myCalendar.time))

    }

}