package com.example.admin.todov1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.admin.todov1.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {


    val arrayTodoItems = ArrayList<String>()
    //val todoItemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayTodoItems)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        arrayTodoItems.add("Einkauf")
        arrayTodoItems.add("Abwasch")

        val todoItemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayTodoItems)
        lstToDo.adapter = todoItemsAdapter

        btnAddItem.setOnClickListener {
            val addItem = Intent(this, AddItem::class.java)
            startActivityForResult(addItem, Keys.REQUEST)
        }

        btnRefresh.setOnClickListener{
            todoItemsAdapter.notifyDataSetChanged()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null){
            data.getStringExtra(Keys.NAME)
            val item = data.getStringExtra(Keys.NAME)
            arrayTodoItems.add(item)
            //todoItemsAdapter.notifyDataSetChanged()
        }
    }

    override fun showItem(item: String) {

    }

}
