package com.example.databasetwo.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.databasetwo.Database.DatabaseHelper
import com.example.databasetwo.Models.ExpenseModel
import com.example.databasetwo.Models.ItemModel
import com.example.databasetwo.R

class RecViewAdapter : RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    private var arrItem : ArrayList<ItemModel> = ArrayList()
    private var context : Context? = null
//    private lateinit var mListener : OnItemClickListener

    constructor(context: Context,arrItem : ArrayList<ItemModel>) : super()
    {
        this.context=context
        this.arrItem=arrItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context!!).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: RecViewAdapter.ViewHolder, position: Int) {
        holder.tvItem.text = arrItem.get(position).itemName
        holder.tvAmount.text = arrItem.get(position).itemAmount.toString()
//        holder.btnDelete.setOnClickListener()
//        {
//            var dbHelper = DatabaseHelper(context!!)
//            dbHelper.delete(position)
//        }
//        holder.btnUpdate.setOnClickListener(){
//            var expenseModel = ExpenseModel()
//            expenseModel.item = arrItem.get(position).itemName
//            expenseModel.amount = arrItem.get(position).itemAmount
//            expenseModel.id = arrItem.get(position).itemId
//
//            var dbHelper = DatabaseHelper(context!!)
//            dbHelper.update(expenseModel)
//        }
    }

    override fun getItemCount(): Int {
        return arrItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener{
//                listener.onItemClick(adapterPosition)
//            }
//        }
        var tvItem : TextView = itemView.findViewById(R.id.tvItem)
        var tvAmount : TextView = itemView.findViewById(R.id.tvAmount)
//        var btnUpdate : Button = itemView.findViewById(R.id.btnUpdate)
//        var btnDelete : Button = itemView.findViewById(R.id.btnDelete)
    }

//    interface OnItemClickListener{
//        fun onItemClick(position: Int)
//    }
//
//    fun onItemClickListener(listener: OnItemClickListener)
//    {
//        mListener = listener
//    }

}