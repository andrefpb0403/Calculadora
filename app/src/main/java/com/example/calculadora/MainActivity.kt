package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var resultado: TextView? = null
    private var equacao: TextView? = null
    private var operacao1: Double? = null
    private var operacaoPendente = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultado = findViewById<TextView>(R.id.tv_resultado)
        val equacao = findViewById<TextView>(R.id.tv_equacao)

        val btn_soma = findViewById<Button>(R.id.btn_soma)
        val btn_subtracao = findViewById<Button>(R.id.btn_subtracao)
        val btn_multiplicacao = findViewById<Button>(R.id.btn_multiplicacao)
        val btn_divisao = findViewById<Button>(R.id.btn_divisao)
        val btn_ponto = findViewById<Button>(R.id.btn_ponto)
        val btn_zero = findViewById<Button>(R.id.btn_zero)
        val btn_um = findViewById<Button>(R.id.btn_um)
        val btn_dois = findViewById<Button>(R.id.btn_dois)
        val btn_tres = findViewById<Button>(R.id.btn_tres)
        val btn_quatro = findViewById<Button>(R.id.btn_quatro)
        val btn_cinco = findViewById<Button>(R.id.btn_cinco)
        val btn_seis = findViewById<Button>(R.id.btn_seis)
        val btn_sete = findViewById<Button>(R.id.btn_sete)
        val btn_oito = findViewById<Button>(R.id.btn_oito)
        val btn_nove = findViewById<Button>(R.id.btn_nove)
        val btn_limpar = findViewById<Button>(R.id.btn_limpar)
        val btn_porcentagem = findViewById<Button>(R.id.btn_porcentagem)
        val btn_alternar = findViewById<Button>(R.id.btn_alternar)
        val btn_apagar = findViewById<Button>(R.id.btn_apagar)
        val btn_resultado = findViewById<Button>(R.id.btn_resultado)

        val botoesNumeros = View.OnClickListener { v ->
            val botao = v as Button
            val textoAtual = equacao.text.toString()
            equacao.text = textoAtual + botao.text.toString()
        }

        btn_ponto.setOnClickListener(botoesNumeros)
        btn_zero.setOnClickListener(botoesNumeros)
        btn_um.setOnClickListener(botoesNumeros)
        btn_dois.setOnClickListener(botoesNumeros)
        btn_tres.setOnClickListener(botoesNumeros)
        btn_quatro.setOnClickListener(botoesNumeros)
        btn_cinco.setOnClickListener(botoesNumeros)
        btn_seis.setOnClickListener(botoesNumeros)
        btn_sete.setOnClickListener(botoesNumeros)
        btn_oito.setOnClickListener(botoesNumeros)
        btn_nove.setOnClickListener(botoesNumeros)

        val botoesOperadores = View.OnClickListener { v ->
            val opBotao = v as Button
            val valor = equacao.text.toString().toDoubleOrNull()
            if (valor != null) {
                performanceCalculo(valor, opBotao.text.toString())
            }
            operacaoPendente = opBotao.text.toString()
        }
        btn_soma.setOnClickListener(botoesOperadores)
        btn_subtracao.setOnClickListener(botoesOperadores)
        btn_multiplicacao.setOnClickListener(botoesOperadores)
        btn_divisao.setOnClickListener(botoesOperadores)

        btn_resultado.setOnClickListener {
            val valor = resultado.text.toString().toDoubleOrNull()
            if (valor != null) {
                performanceCalculo(valor, operacaoPendente)
            }
            operacaoPendente = ""
        }

        btn_limpar.setOnClickListener {
            equacao.setText("")
            resultado.setText("")
            operacao1 = null
            operacaoPendente = ""
        }
    }
    fun performanceCalculo(valor: Double, operacao: String) {
        if (operacao1 == null) {
            operacao1 = valor
        } else {
            val resultadoFinal = when (operacao) {
                "+" -> operacao1!! + valor
                "-" -> operacao1!! - valor
                "*" -> operacao1!! * valor
                "/" -> operacao1!! / valor
                else -> operacao1
            }
        }
        resultado?.setText(operacao1.toString())
        equacao?.setText(operacao1.toString())

    }

}
