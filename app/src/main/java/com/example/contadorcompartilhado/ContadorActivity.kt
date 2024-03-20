package com.example.contadorcompartilhado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ContadorActivity : AppCompatActivity() {

    private fun parseValue (value: String?): Int {
        if (value.isNullOrEmpty()) {
            return 0;
        }

        try {
            return value.toInt();
        } catch (error: NumberFormatException) {
            println(error);
        }
        return 0;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        var btnIncrement = findViewById<Button>(R.id.btn_increment);
        var tvCounter = findViewById<TextView>(R.id.tv_counter);

        val initialValue = parseValue(intent.getStringExtra("initialValue"));

        var counter = initialValue;

        tvCounter.setText(counter.toString().padStart(2, '0'));


        btnIncrement.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                counter++;
                tvCounter.setText(counter.toString().padStart(2, '0'));
            }
        });
    }
}