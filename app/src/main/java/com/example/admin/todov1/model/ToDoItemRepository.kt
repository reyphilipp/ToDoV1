package com.example.admin.todov1.model

object ToDoItemRepository {
    private val items = arrayListOf<ToDoItem>()

    fun createItem(id:Int, item:String){
        items.add(ToDoItem(id, item))
    }

    fun getItem() : ArrayList<ToDoItem>{
        return items
    }
}