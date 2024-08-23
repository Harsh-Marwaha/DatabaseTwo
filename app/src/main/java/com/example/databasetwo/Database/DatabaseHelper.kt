package com.example.databasetwo.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.databasetwo.Models.ExpenseModel

class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, dbName,null, dbVersion) {

    companion object{

        private val dbName = "expense.DB"
        private val dbVersion = 1
        private val tableName = "MyExpenses"
        private val keyId = "ID"
        private val keyItem = "Item"
        private val keyAmount = "Amount"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $tableName ($keyId INTEGER PRIMARY KEY AUTOINCREMENT,$keyItem TEXT, $keyAmount INTEGER)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(p0)
    }

    public fun addItem(item : String, amount: Int){
        var db : SQLiteDatabase
        db = this.writableDatabase
        var values = ContentValues()
        values.put(keyItem,item)
        values.put(keyAmount,amount)
        db.insert(tableName,null,values)
    }

    public fun fetch() : ArrayList<ExpenseModel>
    {
        var db : SQLiteDatabase
        db=this.writableDatabase
        var cursor : Cursor
        cursor = db.rawQuery("SELECT *FROM $tableName",null)
        var arrExpenses : ArrayList<ExpenseModel> = ArrayList()
        while (cursor.moveToNext())
        {
            var model = ExpenseModel()
            model.id = cursor.getInt(0)
            model.item = cursor.getString(1)
            model.amount = cursor.getInt(2)
        }
        return arrExpenses
    }

    public fun update(expenseModel: ExpenseModel){
        var db : SQLiteDatabase
        db=this.writableDatabase
        var values = ContentValues()
        values.put(keyItem,expenseModel.item)
        values.put(keyAmount,expenseModel.amount)
        db.update(tableName,values,"$keyId = ${expenseModel.id}", null)
    }

    public fun delete(id : Int){
        var db : SQLiteDatabase
        db = this.writableDatabase
        db.delete(tableName,"$keyId =? ", arrayOf(id.toString()))
    }

}