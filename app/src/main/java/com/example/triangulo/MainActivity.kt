package com.example.triangulo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var tfCatetoB : EditText
    lateinit var tfCatetoC : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tfCatetoB = findViewById(R.id.tfCatetoB)
        tfCatetoC = findViewById(R.id.tfCatetoC)
    }

    fun buttonCalcularPressed(v: View){
        if(camposLlenos()){
            if(camposValidos()){
                var catetoB : Double = tfCatetoB.text.toString().toDouble()
                var catetoC : Double = tfCatetoC.text.toString().toDouble()
                var result : Double;
                var bPow2 : Double = catetoB.pow(2)
                var cPow2 : Double = catetoC.pow(2)
                result = (bPow2 + cPow2).pow(.5)
                var message = "El resultado es ${result}."
                showMessage(message)
                limpiarCampos()
            }else{
                showMessage("Asegúrese de ingresar valores mayores a 0 para formar un triángulo válido.")
            }

        }else{
            showMessage("Campos Vacíos")
        }
    }

    private fun camposValidos(): Boolean {
        var catetoB : Double = tfCatetoB.text.toString().toDouble()
        var catetoC : Double = tfCatetoC.text.toString().toDouble()

        return catetoB > 0 &&
                catetoC > 0
    }

    fun camposLlenos(): Boolean {
        return !tfCatetoB.text.toString().equals("") &&
                !tfCatetoC.text.toString().equals("")
    }

    fun showMessage(mensaje : String){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

    fun limpiarCampos(){
        tfCatetoC.text.clear()
        tfCatetoB.text.clear()
    }
}