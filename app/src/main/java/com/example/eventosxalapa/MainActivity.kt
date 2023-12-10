package com.example.eventosxalapa

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventosxalapa.Models.EventosProvider
import com.example.eventosxalapa.Models.Promotor
import com.example.eventosxalapa.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnHoy = binding.btnHoy
        val btnSemana = binding.btnSemana
        val btnMes = binding.btnMes

        val btnGratis = binding.button
        var btnPaga = binding.button2

        val drawerLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_buscar -> Toast.makeText(this@MainActivity,"Accion",Toast.LENGTH_LONG).show()
            }
            when(it.itemId){
                R.id.nav_Regitrar -> {
                    val intent = Intent(this@MainActivity, RegistroOrgActivity::class.java)
                    startActivity(intent)}
            }

            true
        }




        btnHoy.setOnClickListener {
            cargarLista()
        }

        btnSemana.setOnClickListener {
            cargarListaSemana()
        }

        btnMes.setOnClickListener {
            cargarListaMes()
        }


        btnGratis.setOnClickListener{
            cargarListaGratis()
        }

        btnPaga.setOnClickListener{
            cargarListaPaga()

        }


        cargarLista()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
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

    private fun cargarListaGratis(){
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventoAdapter(EventosProvider.listaGratis)
    }

    private fun cargarListaPaga(){
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EventoAdapter(EventosProvider.listaPaga)
    }


}