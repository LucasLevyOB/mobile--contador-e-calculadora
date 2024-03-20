package com.example.contadorcompartilhado

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculadora = findViewById<Button>(R.id.btn_calculadora);
        val btnContador = findViewById<Button>(R.id.btn_contador);
        val edtCountInitial = findViewById<EditText>(R.id.edt_count_initial);

        btnCalculadora.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, CalculadoraActivity::class.java);
                startActivity(intent);
            }
        });

        btnContador.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, ContadorActivity::class.java);
                intent.putExtra("initialValue", edtCountInitial.text.toString());

                startActivity(intent);
            }
        });
    }
}