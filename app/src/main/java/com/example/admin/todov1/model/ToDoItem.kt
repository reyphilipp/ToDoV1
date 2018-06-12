package com.example.admin.todov1.model

data class ToDoItem(val id:Int, val item:String) {

    override fun toString(): String {
        return "$id: $item"
    }
}