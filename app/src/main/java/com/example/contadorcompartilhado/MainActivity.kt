package com.example.contadorcompartilhado

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalculadora = findViewById<Button>(R.id.btn_calculadora);
        var btnContador = findViewById<Button>(R.id.btn_contador);

        btnCalculadora.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var intent = Intent(applicationContext, CalculadoraActivity::class.java);
                startActivity(intent);
            }
        });

        btnContador.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var intent = Intent(applicationContext, ContadorActivity::class.java);
                startActivity(intent);
            }
        });
    }
}