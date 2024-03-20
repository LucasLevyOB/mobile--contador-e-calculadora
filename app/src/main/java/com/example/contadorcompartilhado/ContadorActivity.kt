package com.example.contadorcompartilhado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ContadorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        var btnIncrement = findViewById<Button>(R.id.btn_increment);
        var tvCounter = findViewById<TextView>(R.id.tv_counter);

        var counter = 0;

        btnIncrement.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                counter++;
                tvCounter.setText(counter.toString().padStart(2, '0'));
            }
        });
    }
}