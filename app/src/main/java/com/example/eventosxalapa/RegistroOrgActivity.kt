package com.example.eventosxalapa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventosxalapa.databinding.ActivityMainBinding
import com.example.eventosxalapa.databinding.ActivityRegistroOrgBinding

class RegistroOrgActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroOrgBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_org)

        binding = ActivityRegistroOrgBinding.inflate(layoutInflater)
        val btnAtras = binding.btnAtras

        btnAtras.setOnClickListener {
            Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show()
        }

    }
}