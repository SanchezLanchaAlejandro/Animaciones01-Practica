package com.example.animaciones

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Referencias a las vistas
        val imagenAnillo: ImageView = findViewById(R.id.imagenAnillo)
        val imagenBrillo: ImageView = findViewById(R.id.imagenBrillo)
        val botonCambiarColor: Button = findViewById(R.id.botonCambiarColor)

        // Configurar el AnimatedVectorDrawable como imagen del anillo
        imagenAnillo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.animacion_colores))

        // Cargar el AnimationDrawable para el brillo
        val brilloDrawable = imagenBrillo.drawable as AnimationDrawable

        // Acciones al presionar el botón
        botonCambiarColor.setOnClickListener {
            // Iniciar la animación de cambio de color del anillo
            val drawable = imagenAnillo.drawable
            if (drawable is AnimatedVectorDrawable) {
                drawable.start()
            }

            // Iniciar la animación de brillo
            imagenBrillo.visibility = ImageView.VISIBLE
            brilloDrawable.start()
        }
    }
}