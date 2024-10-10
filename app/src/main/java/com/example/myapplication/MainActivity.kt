package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var apellidos: EditText
    private lateinit var correo: EditText
    private lateinit var radioGroupSexo: RadioGroup
    private lateinit var spinner: Spinner
    private lateinit var textViewResultados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.nombre)
        apellidos = findViewById(R.id.apellidos)
        correo = findViewById(R.id.correo)
        radioGroupSexo = findViewById(R.id.radioGroupSexo)
        spinner = findViewById(R.id.spinner)
        textViewResultados = findViewById(R.id.textViewResultados)
        val registrar: Button = findViewById(R.id.registrar)

        // Configura el spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        registrar.setOnClickListener { registrarUsuario() }
    }

    private fun registrarUsuario() {
        val nombreTexto = nombre.text.toString()
        val apellidosTexto = apellidos.text.toString()
        val correoTexto = correo.text.toString()
        val selectedId = radioGroupSexo.checkedRadioButtonId
        val radioButton: RadioButton? = findViewById(selectedId)
        val sexoTexto = radioButton?.text.toString()
        val opcionSeleccionada = spinner.selectedItem.toString()

        // Verifica si alguno de los campos está vacío
        if (nombreTexto.isEmpty() || apellidosTexto.isEmpty() || correoTexto.isEmpty() || sexoTexto.isEmpty() || opcionSeleccionada.isEmpty()) {
            // Muestra un Toast con un mensaje de advertencia
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return // Sale del método si hay campos vacíos
        }

        // Actualiza el TextView con los datos ingresados
        val resultado = "Nombre: $nombreTexto\nApellidos: $apellidosTexto\nCorreo: $correoTexto\nSexo: $sexoTexto\nEscuela: $opcionSeleccionada"
        textViewResultados.text = resultado

        // Muestra un Toast (opcional)
        Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show()
    }

}

