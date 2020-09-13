package com.example.demo.models

import android.widget.Toast
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class Registro (var nombres: String = "", var apellidos: String = "", var correo : String = ""){

    suspend fun registrarDatos (): String {

        return when {

            nombres.toString().isEmpty() || apellidos.toString().isEmpty() || correo.toString().isEmpty() -> {
                "Ingrese datos validos"
            }
            else -> {
                "Te has registrado correctamente en la comunidad"
            }
        }
    }
}