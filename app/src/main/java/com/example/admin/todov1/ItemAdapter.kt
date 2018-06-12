package com.example.admin.todov1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.admin.todov1.model.ToDoItem

class ItemAdapter (context: Context, itemDaten:ArrayList<ToDoItem>) : BaseAdapter() {

    private val context:Context = context
    private val itemDate = itemDaten

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val listenEintrag = layoutInflater.inflate(R.layout.item_layout, parent, false)

        val idTxt = listenEintrag.findViewById<TextView>(R.id.txtId)
        val itemTxt = listenEintrag.findViewById<TextView>(R.id.txtItem)

        val item = itemDate.get(position)

        idTxt.text = item.id.toString()
        itemTxt.text = item.item

        return listenEintrag
    }

    override fun getItem(position: Int): Any {
        return itemDate.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return itemDate.size
    }
}