package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demo.models.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var oUsuario = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSubmit.setOnClickListener{

            oUsuario.apply {
                username = usuarioTextBox.text.toString()
                contrasena = contrasenaTextBox.text.toString()
            }

            /**
             * Los Getters and setters son para modificar atributos de la clase.
             *
             * MVC: Modelo Vista Controlador (Puente del Modelo y Vista)
             * MVP: Modelo Vista Presentador (Presentador de data conectado a la vista)
             * MVVM: Modelo View ViewModel(Logica de negocio)
             */

            /*
            * Versión Nro 1  - Validación de las credenciales inline
            oUsuario.let {
                when {
                    it.username == "jhorman" && it.contrasena == "123" -> {
                        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    }
                    else -> {
                        Toast.makeText(this, "Intente nuevamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            *
            * Versión Nro 2 - Validación en como metodo en el modelo.
            oUsuario.let {
                Toast.makeText(this, it.message(), Toast.LENGTH_SHORT).show()
            }
            */

            GlobalScope.launch(Dispatchers.Main) {
                oUsuario.let {
                    Toast.makeText(this@MainActivity, it.iniciarSesion(), Toast.LENGTH_SHORT).show()
                }
            }

            val vistaRegistro  = Intent(this@MainActivity, Registro::class.java)

            vistaRegistro.putExtra("username", oUsuario.username)
            //vistaRegistro.putExtra("contrasena",oUsuario.contrasena)

            startActivity(vistaRegistro)

        }

    }
}