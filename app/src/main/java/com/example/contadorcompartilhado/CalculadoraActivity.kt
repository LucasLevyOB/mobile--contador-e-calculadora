package com.example.contadorcompartilhado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.text.ParseException

enum class CalcOperation {
    SUM,
    SUBTRACT,
    MULTI,
    DIVIDE
}

class CalculadoraActivity : AppCompatActivity() {
    lateinit var tvVisor: TextView;
    lateinit var edtFirstValue: EditText;
    lateinit var edtSecondValue: EditText;

    fun setVisorText (value: String) {
        tvVisor.setText("Resultado: " + value);
    }

    private fun convertValue (value: String): Float {
        try {
            return value.toFloat();
        } catch (error: NumberFormatException) {
            println(error);
        }
        return 0f;
    }

    private fun checkRequiredValues (): Boolean {
        val value1 = edtFirstValue.text.toString();
        val value2 = edtSecondValue.text.toString();

        var message: String = "Por favor, preencha os seguintes campos:";

        if (value1.isEmpty()) {
            message += " Primeiro Valor" + if (value2.isEmpty()) " e" else "";
        }
        if (value2.isEmpty()) {
            message += " Segundo Valor";
        }
        message += ";";

        if (value1.isEmpty() || value2.isEmpty()) {
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;

    }

    fun calcOperation (operation: CalcOperation): String {
        if (checkRequiredValues()) {
            return "";
        }

        val value1 = convertValue(edtFirstValue.text.toString());
        val value2 = convertValue(edtSecondValue.text.toString());

        val result = when(operation) {
            CalcOperation.SUM -> value1 + value2
            CalcOperation.SUBTRACT -> value1 - value2
            CalcOperation.MULTI -> value1 * value2
            CalcOperation.DIVIDE -> value1 / value2
            else -> 0f
        }

        return result.toString();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        this.tvVisor = findViewById<TextView>(R.id.tv_visor);

        this.edtFirstValue = findViewById<EditText>(R.id.edt_first_value);
        this.edtSecondValue = findViewById<EditText>(R.id.edt_second_value);

        val btnSum = findViewById<Button>(R.id.btn_sum);
        val btnSubtract = findViewById<Button>(R.id.btn_subtract);
        val btnMulti = findViewById<Button>(R.id.btn_multiply);
        val btnDivide = findViewById<Button>(R.id.btn_divide);

        btnSum.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(CalcOperation.SUM);
                setVisorText(result);
            }
        });

        btnSubtract.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(CalcOperation.SUBTRACT);
                setVisorText(result);
            }
        });

        btnMulti.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(CalcOperation.MULTI);
                setVisorText(result);
            }
        });

        btnDivide.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(CalcOperation.DIVIDE);
                setVisorText(result);
            }
        });

    }
}