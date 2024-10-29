package com.example.simplelist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.simplelist.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val radioEven = findViewById<RadioButton>(R.id.radioEven)
        val radioOdd = findViewById<RadioButton>(R.id.radioOdd)
        val radioSquare = findViewById<RadioButton>(R.id.radioSquare)
        val buttonShow = findViewById<Button>(R.id.buttonShow)
        val listView = findViewById<ListView>(R.id.listView)

        buttonShow.setOnClickListener {
            val n = inputNumber.text.toString().toIntOrNull()

            if (n == null) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultList = when {
                radioEven.isChecked -> generateEvenNumbers(n)
                radioOdd.isChecked -> generateOddNumbers(n)
                radioSquare.isChecked -> generateSquareNumbers(n)
                else -> listOf()
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
            listView.adapter = adapter
        }
    }

    private fun generateEvenNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 == 0 }
    }

    private fun generateOddNumbers(n: Int): List<Int> {
        return (1..n).filter { it % 2 != 0 }
    }

    private fun generateSquareNumbers(n: Int): List<Int> {
        val resultList = mutableListOf<Int>()
        var i = 0
        while (i * i <= n) {
            resultList.add(i * i)
            i++
        }
        return resultList
    }
}
