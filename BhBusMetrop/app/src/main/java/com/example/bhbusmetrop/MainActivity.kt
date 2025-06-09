package com.example.bhbusmetrop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNome = findViewById<EditText>(R.id.etNome)
        val editTextNumero = findViewById<EditText>(R.id.etNumero)
        val editTextCor = findViewById<EditText>(R.id.etCor)
        val editTextTipo = findViewById<EditText>(R.id.etTipo)
        val editTextPeso = findViewById<EditText>(R.id.etPeso)
        val buttonEnviar = findViewById<Button>(R.id.btnEnviar)

        buttonEnviar.setOnClickListener {
            val nome = editTextNome.text.toString().trim()
            val numero = editTextNumero.text.toString().trim()
            val cor = editTextCor.text.toString().trim()
            val tipo = editTextTipo.text.toString().trim()
            val peso = editTextPeso.text.toString().trim()

            if (nome.isEmpty() || numero.isEmpty() || cor.isEmpty() || tipo.isEmpty() || peso.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra("nome", nome)
                    putExtra("numero", numero)
                    putExtra("cor", cor)
                    putExtra("tipo", tipo)
                    putExtra("peso", peso)
                }
                startActivity(intent)
            }
        }
    }
}