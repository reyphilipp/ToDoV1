package com.example.admin.todov1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.admin.todov1.model.ToDoModel
import com.example.admin.todov1.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    val toDoModel = ToDoModel(this)
    val todoItemsAdapter = ItemAdapter(this, toDoModel.getItem())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lstToDo.adapter = todoItemsAdapter

        btnAddItem.setOnClickListener {
            val addItem = Intent(this, AddItem::class.java)
            startActivityForResult(addItem, Keys.REQUEST)
        }

        btnRefresh.setOnClickListener{
            todoItemsAdapter.notifyDataSetChanged()
        }

        lstToDo.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Geklickt wurde: ${toDoModel.getItem().get(position)}", Toast.LENGTH_SHORT).show()
            val detailIntent = Intent(this, DetailActivity::class.java)
            detailIntent.putExtra(Keys.NAME, toDoModel.getItem().get(position).item)
            detailIntent.putExtra(Keys.ID, toDoModel.getItem().get(position).id.toString())
            startActivity(detailIntent)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null){
            data.getStringExtra(Keys.NAME)
            val item = data.getStringExtra(Keys.NAME)
            toDoModel.createItem(item)
            todoItemsAdapter.notifyDataSetChanged()
        }
    }

    override fun showItem(item: String) {

    }
    override fun updateLastId(lastId: Int) {

    }

}
