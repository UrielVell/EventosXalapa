package com.example.eventosxalapa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventosxalapa.Models.EventosProvider
import com.example.eventosxalapa.Models.Promotor
import com.example.eventosxalapa.databinding.ActivityMainBinding
import com.example.eventosxalapa.util.Constantes
import com.google.android.material.navigation.NavigationView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private val startActivityResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode == Activity.RESULT_OK){
            var result = it.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            binding.editTextText.setText(result!![0])
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnHoy = binding.btnHoy
        val btnSemana = binding.btnSemana
        val btnMes = binding.btnMes

        val btnGratis = binding.button
        var btnPaga = binding.button2

        val btnMicro = binding.btnMicro

        val drawerLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_buscar -> binding.editTextText.requestFocus()
            }
            when(it.itemId){
                R.id.nav_Regitrar -> {
                    val intent = Intent(this@MainActivity, RegistroOrgActivity::class.java)
                    startActivityForResult(intent, Constantes.REQUEST_CODE_REGISTRO)}
            }
            when(it.itemId){
                R.id.nav_favorito -> Toast.makeText(applicationContext, "Mostrar eventos guardados", Toast.LENGTH_SHORT).show()
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

        btnMicro.setOnClickListener {
            binding.editTextText.setText("")
            escuchar()
        }

        binding.editTextText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                filtrar(s.toString())
            }

        })


        cargarLista()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constantes.REQUEST_CODE_REGISTRO && resultCode == RESULT_OK) {
            // La validación en RegistroOrgActivity fue exitosa, cierra MainActivity
            finish()
        }
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

    fun escuchar(){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        if (intent.resolveActivity(packageManager) != null){
            startActivityResult.launch(intent)
        }else{
            Toast.makeText(applicationContext,"Busqueda por voz no disponible", Toast.LENGTH_SHORT).show()
        }
    }

    fun filtrar(texto: String){
        when(texto.lowercase()){
            "hoy" -> cargarLista()
            "semana" -> cargarListaSemana()
            "mes" -> cargarListaMes()
            "gratis" -> cargarListaGratis()
            "paga" -> cargarListaPaga()
        }
    }


}