package com.example.admin.todov1

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_item.*

class AddItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        btnSaveItem.setOnClickListener {
            intent.putExtra(Keys.NAME, txtItem.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }
}
