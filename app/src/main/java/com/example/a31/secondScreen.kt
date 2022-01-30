package com.example.a31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class secondScreen : AppCompatActivity() {

    var firstNumber: Int = 0
    var secondNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guessing)

        firstNumber = intent.getIntExtra("fNum", firstNumber)
        secondNumber = intent.getIntExtra("sNum", secondNumber)

        val num: Int = (firstNumber+secondNumber+1)/2
        val s: String = getString(R.string.question).replace("\$num", "$num")

        val question : TextView = findViewById(R.id.question)
        question.setText(s)

        val b1: Button = findViewById(R.id.eqgtButton)
        val b2: Button = findViewById(R.id.ltButton)
        Toast.makeText(this, "$firstNumber $secondNumber", Toast.LENGTH_SHORT).show()
        b1.setOnClickListener(){

            if(calc(true)){
                b1.isEnabled = false
                b2.isEnabled = false
            }
            Toast.makeText(this, "$firstNumber $secondNumber", Toast.LENGTH_SHORT).show()
        }
        b2.setOnClickListener(){

            if(calc(false)){
                b1.isEnabled = false
                b2.isEnabled = false
            }
            Toast.makeText(this, "$firstNumber $secondNumber", Toast.LENGTH_SHORT).show()
        }


    }

    private fun calc(gt: Boolean):Boolean
    {
        val question : TextView = findViewById(R.id.question)

        var num: Int = (firstNumber+secondNumber+1)/2
        if (gt)
            firstNumber = num
        else
            secondNumber = num - 1

        if (firstNumber==secondNumber)
        {
            question.setText(getString(R.string.answer).replace("\$num", "$firstNumber"))
            return true
        }

        num = (firstNumber+secondNumber+1)/2
        question.setText(getString(R.string.question).replace("\$num", "$num"))
        return false
    }
}