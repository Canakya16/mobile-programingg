package com.example.mobileprogramming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_activity: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_activity = findViewById(R.id.btn_activity)
        btn_activity.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_activity -> {
                val moveIntent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(moveIntent)
            }
        }
    }
}





