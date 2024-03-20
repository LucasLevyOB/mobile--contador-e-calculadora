package com.example.contadorcompartilhado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

    fun setVisorText (value: String) {
        tvVisor.setText("Resultado: " + value);
    }

    fun convertValue (value: String): Float {
        try {
            return value.toFloat();
        } catch (error: NumberFormatException) {
            println(error);
        }
        return 0f;
    }

    fun calcOperation (editText: EditText, editText2: EditText, operation: CalcOperation): String {
        val value1 = convertValue(editText.text.toString());
        val value2 = convertValue(editText2.text.toString());

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

        val edtFirstValue = findViewById<EditText>(R.id.edt_first_value);
        val edtSecondValue = findViewById<EditText>(R.id.edt_second_value);

        val btnSum = findViewById<Button>(R.id.btn_sum);
        val btnSubtract = findViewById<Button>(R.id.btn_subtract);
        val btnMulti = findViewById<Button>(R.id.btn_multiply);
        val btnDivide = findViewById<Button>(R.id.btn_divide);

        btnSum.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(edtFirstValue, edtSecondValue, CalcOperation.SUM);
                setVisorText(result);
            }
        });

        btnSubtract.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(edtFirstValue, edtSecondValue, CalcOperation.SUBTRACT);
                setVisorText(result);
            }
        });

        btnMulti.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(edtFirstValue, edtSecondValue, CalcOperation.MULTI);
                setVisorText(result);
            }
        });

        btnDivide.setOnClickListener(object: View.OnClickListener {
            override fun onClick (view: View?) {
                val result = calcOperation(edtFirstValue, edtSecondValue, CalcOperation.DIVIDE);
                setVisorText(result);
            }
        });

    }
}