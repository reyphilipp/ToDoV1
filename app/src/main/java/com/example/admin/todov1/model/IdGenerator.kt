package com.example.admin.todov1.model

object IdGenerator {
    var id = 0

    fun generateId() : Int {
        id++
        return id
    }
}