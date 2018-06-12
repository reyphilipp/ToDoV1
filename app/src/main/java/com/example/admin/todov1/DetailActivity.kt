package com.example.admin.todov1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.item_layout.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getStringExtra(Keys.NAME)
        val id = intent.getStringExtra(Keys.ID)

        txtItem.text = item
        txtId.text = id
    }
}
