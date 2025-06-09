package com.example.bhbusmetrop

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewNome = findViewById<TextView>(R.id.tvNome)
        val textViewNumero = findViewById<TextView>(R.id.tvNumero)
        val textViewCor = findViewById<TextView>(R.id.tvCor)
        val textViewTipo = findViewById<TextView>(R.id.tvTipo)
        val textViewPeso = findViewById<TextView>(R.id.tvPeso)
        val botaoVoltar = findViewById<Button>(R.id.btnVoltarTelaInicial)

        val nome = intent.getStringExtra("nome")
        val numero = intent.getStringExtra("numero")
        val cor = intent.getStringExtra("cor")
        val tipo = intent.getStringExtra("tipo")
        val peso = intent.getStringExtra("peso")

        textViewNome.text = "Nome: $nome"
        textViewNumero.text = "Número: $numero"
        textViewCor.text = "Cor: $cor"
        textViewTipo.text = "Tipo: $tipo"
        textViewPeso.text = "Peso: $peso kg"

        botaoVoltar.setOnClickListener {
            onBackPressed()
        }
    }
}