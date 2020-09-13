package com.example.demo.models

import android.widget.Toast
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class Usuario (var username: String = "", var contrasena: String = ""){

    suspend fun iniciarSesion (): String {

        /*
         * Es recomendable usar los hilos cuando se realiza peticiiones asincronas.
         */

        // delay(TimeUnit.SECONDS.toMillis(2))

        return when {

            username.isEmpty() || contrasena.isEmpty() -> {
                "Ingrese datos validos"
            }
            else -> {
                "Autenticación exitosa"
            }
        }
    }
}