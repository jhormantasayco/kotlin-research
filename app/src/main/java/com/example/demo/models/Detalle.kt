package com.example.demo.models

import android.widget.Toast
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class Detalle (var nombres: String = "", var apellidos: String = "", var correo : String = ""){

    suspend fun obtenerDatos (): String {

        return when {

            nombres.toString().isEmpty() || apellidos.toString().isEmpty() || correo.toString().isEmpty() -> {
                "Los datos son invalidos"
            }
            else -> {
                "Información: ${nombres} ${apellidos} - {$correo}"
            }
        }
    }
}