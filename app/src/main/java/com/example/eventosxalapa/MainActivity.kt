package com.example.eventosxalapa

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventosxalapa.Controlers.EventosAdapter
import com.example.eventosxalapa.Models.EventosProvider
import com.example.eventosxalapa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarLista()
    }


    private fun cargarLista(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLista)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventosAdapter(EventosProvider.eventos)
    }


}