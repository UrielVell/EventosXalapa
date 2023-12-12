package com.example.eventosxalapa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventosxalapa.Models.Promotor
import com.example.eventosxalapa.databinding.ActivityRegistroOrgBinding

class RegistroOrgActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroOrgBinding
    private lateinit var promotor: Promotor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroOrgBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val btnRegistro = binding.btnRegistar
        val btnAtras = binding.btnAtras

        btnRegistro.setOnClickListener {
            var organizacion = binding.tvOrganizacion.text.toString()
            var email = binding.tvEmail.text.toString()
            var contrasena = binding.tvContrasena.text.toString()

            if (validarCampos(organizacion,email,contrasena)){
                promotor = inicializarPromotor(organizacion,email,contrasena)
                Toast.makeText(this@RegistroOrgActivity,"Bienvenido "+organizacion+ ": Ahora puedes agendar Eventos",Toast.LENGTH_LONG).show()
                val intent = Intent(this@RegistroOrgActivity, MainActivity2::class.java)
                setResult(RESULT_OK)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@RegistroOrgActivity,"campos invalidos",Toast.LENGTH_LONG).show()

            }



        }

        btnAtras.setOnClickListener{
            finish()
        }



    }

    fun inicializarPromotor(organizacion: String, email: String, contrasena: String): Promotor {
        val promotor = Promotor()
        promotor.organizacion = organizacion
        promotor.email = email
        promotor.contrasena = contrasena
        return  promotor
    }

    fun validarCampos(organizacion: String, email: String, contrasena: String):Boolean{
        var retorno: Boolean = true
        if (organizacion.isEmpty()|| email.isEmpty()
            || contrasena.isEmpty()){
            retorno=false
        }
        return retorno
    }
}