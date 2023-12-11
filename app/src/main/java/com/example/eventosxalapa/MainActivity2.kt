package com.example.eventosxalapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventosxalapa.Models.EventosProvider
import com.example.eventosxalapa.databinding.ActivityMain2Binding
import com.example.eventosxalapa.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnHoy = binding.btnHoy
        val btnSemana = binding.btnSemana
        val btnMes = binding.btnMes

        val btnGratis = binding.button
        var btnPaga = binding.button2

        val drawerLayout : DrawerLayout = binding.drawerLayout2
        val navView : NavigationView = findViewById(R.id.nav_view2)

        toggle = ActionBarDrawerToggle(this@MainActivity2,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_buscar -> binding.editTextText.requestFocus()
            }
            when(it.itemId){
                R.id.nav_Regitrar -> {
                    val intent = Intent(this@MainActivity2, RegistroOrgActivity::class.java)
                    startActivity(intent)}
            }
            when(it.itemId){
                R.id.nav_agregar -> Toast.makeText(this@MainActivity2, "Accion de agregar evento", Toast.LENGTH_SHORT).show()
            }
            when(it.itemId){
                R.id.nav_cerrar -> Toast.makeText(this@MainActivity2, "Accion de cerrar sesion", Toast.LENGTH_SHORT).show()
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