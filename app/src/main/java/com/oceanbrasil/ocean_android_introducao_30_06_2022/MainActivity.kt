package com.oceanbrasil.ocean_android_introducao_30_06_2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscar o botão pelo ID
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome )


        btEnviar.setOnClickListener {
            //Dentro desse bloco estamos dentro do clicklistener. Portanto o código
            //que está aqui será executado quando o botão for clicado.

            val nomeDigitado = etNome.text

            if (nomeDigitado.isBlank()) {
                etNome.error = getString(R.string.type_a_valid_name)
            } else {
                tvResultado.text = nomeDigitado
            }
        }

        //Abrir Nova Tela

        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)

        btAbrirNovaTela.setOnClickListener {
            val novaTelaIntent = Intent(this, ResultadoActivity::class.java)

            //Adiciona nome digitado à intent que foi criada
            val nomeDigitado = etNome.text.toString()
            novaTelaIntent.putExtra("NOME_DIGITADO", nomeDigitado)

            startActivity(novaTelaIntent)
        }

    }
}