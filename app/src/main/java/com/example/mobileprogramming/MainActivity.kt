package com.example.mobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var result: TextView
    private lateinit var btn: Button

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputPanjang = findViewById(R.id.edt_length)
        inputLebar = findViewById(R.id.edt_width)
        inputTinggi = findViewById(R.id.edt_height)
        btn = findViewById(R.id.btn_result)
        result = findViewById(R.id.result)

        btn.setOnClickListener(this)

        if (savedInstanceState != null) {
            val textResult = savedInstanceState.getString(STATE_RESULT)
            result.text = textResult
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_result) {
            val panjang = inputPanjang.text.toString().trim()
            val lebar = inputLebar.text.toString().trim()
            val tinggi = inputTinggi.text.toString().trim()
            var isEmptyFields = false
            if (panjang.isEmpty()) {
                isEmptyFields = true
                inputPanjang.error = "Field ini tidak boleh kosong"
            }
            if (lebar.isEmpty()) {
                isEmptyFields = true
                inputLebar.error = "Field ini tidak boleh kosong"
            }
            if (tinggi.isEmpty()) {
                isEmptyFields = true
                inputTinggi.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                var hasil = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                result.text = hasil.toString()
            }
        }
    }
}





