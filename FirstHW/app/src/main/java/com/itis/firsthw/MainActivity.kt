package com.itis.firsthw

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var et_name: EditText
    private lateinit var et_height: EditText
    private lateinit var et_weight: EditText
    private lateinit var et_age: EditText
    private lateinit var button_calculate: Button
    private lateinit var tv_result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_name = findViewById(R.id.et_name)
        et_height = findViewById(R.id.et_height)
        et_weight = findViewById(R.id.et_weight)
        et_age = findViewById(R.id.et_age)
        button_calculate = findViewById(R.id.button_calculate)
        tv_result = findViewById(R.id.tv_result)

        button_calculate.setOnClickListener {
            validateAndCalculate()
        }
    }

    private fun validateAndCalculate() {
        val name = et_name.text.toString().trim()
        val heightStr = et_height.text.toString().trim()
        val weightStr = et_weight.text.toString().trim()
        val ageStr = et_age.text.toString().trim()

        if (name.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty() || ageStr.isEmpty()) {
            tv_result.text = "Данные введены некорректно."
            return
        }

        val height = heightStr.toIntOrNull()
        val weight = weightStr.toFloatOrNull()
        val age = ageStr.toIntOrNull()

        if (height == null || height <= 0 || height >= 250 ||
            weight == null || weight <= 0 || weight >= 250 ||
            age == null || age <= 0 || age >= 150
        ) {
            tv_result.text = "Данные введены некорректно."
            return
        }

        // Расчет результата на основе входных данных
        val value = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)

        tv_result.text = "Ответ: Кол-во калорий - $value"
    }
}
