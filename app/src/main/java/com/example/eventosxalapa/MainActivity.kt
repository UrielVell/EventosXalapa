package com.example.eventosxalapa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventosxalapa.Models.EventosProvider
import com.example.eventosxalapa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnHoy = binding.btnHoy
        val btnSemana = binding.btnSemana
        val btnMes = binding.btnMes

        btnHoy.setOnClickListener {
            cargarLista()
        }

        btnSemana.setOnClickListener {
            cargarListaSemana()
        }

        btnMes.setOnClickListener {
            cargarListaMes()
        }





        cargarLista()
    }

    private fun cargarListaSemana() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventoAdapter(EventosProvider.listaSemana)

    }

    private fun cargarListaMes(){
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventoAdapter(EventosProvider.listaMes)
    }


    private fun cargarLista(){
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventoAdapter(EventosProvider.listaHoy)

    }




}