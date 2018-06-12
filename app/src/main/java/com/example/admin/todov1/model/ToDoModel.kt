package com.example.admin.todov1.model

import com.example.admin.todov1.view.MainView

class ToDoModel(val mainView: MainView) {
    fun createItem(item:String){
        val generatedId = IdGenerator.generateId()
        ToDoItemRepository.createItem(generatedId, item)
        mainView.updateLastId(generatedId)
    }

    fun getItem():ArrayList<ToDoItem>{
        return ToDoItemRepository.getItem()
    }
}