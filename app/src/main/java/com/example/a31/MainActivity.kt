package com.example.a31

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fNum : EditText = findViewById(R.id.editTextTextPersonName)
        val sNum : EditText = findViewById(R.id.editTextTextPersonName2)

        val b :Button = findViewById(R.id.button)
        b.setOnClickListener{
            val intent = Intent(this, secondScreen::class.java)
            try
            {
                var f = fNum.getText().toString().toInt()
                var s = sNum.getText().toString().toInt()
                if (f==s)
                    throw NumberFormatException()
                if (f>s)
                    f = s.also { s = f }
                intent.putExtra("fNum", f)
                intent.putExtra("sNum", s)
                startActivity(intent)
            }
            catch (nfe: NumberFormatException)
            {
                val errMessage :String = getString(R.string.error_range)
                Toast.makeText(this, errMessage, Toast.LENGTH_LONG).show()
            }
        }
    }


}

