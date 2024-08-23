package com.example.databasetwo.Activites

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databasetwo.Adapters.RecViewAdapter
import com.example.databasetwo.Database.DatabaseHelper
import com.example.databasetwo.Models.ExpenseModel
import com.example.databasetwo.Models.ItemModel
import com.example.databasetwo.R

class MainActivity : AppCompatActivity() {

    var edtItem : EditText? = null
    var edtAmount : EditText? = null
    var btnAdd : Button? = null
    var recView : RecyclerView?=null

    var arrItemModel : ArrayList<ItemModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtItem=findViewById(R.id.edtItem)
        edtAmount=findViewById(R.id.edtAmount)
        btnAdd=findViewById(R.id.btnAdd)
        recView=findViewById(R.id.recView)

        var dbHelper = DatabaseHelper(this)

        var expenseModel=ExpenseModel()

        var Id = 1

        btnAdd?.setOnClickListener()
        {
            var strItem : String = edtItem?.text.toString()
            var strAmount : String = edtAmount?.text.toString()
            var intAmount : Int = strAmount.toInt()
            dbHelper.addItem(strItem,intAmount)
            arrItemModel.add(ItemModel(strItem,intAmount))
            expenseModel.item=strItem
            expenseModel.amount=intAmount
            expenseModel.id=Id
            dbHelper.fetch(expenseModel)
            edtItem?.setText("")
            edtAmount?.setText("")
            Toast.makeText(this,"Item added successfully",Toast.LENGTH_LONG).show()
        }

        recView?.layoutManager = LinearLayoutManager(this@MainActivity)
        var recViewAdapter = RecViewAdapter(this@MainActivity,arrItemModel)
        recView?.adapter = recViewAdapter



    }

}