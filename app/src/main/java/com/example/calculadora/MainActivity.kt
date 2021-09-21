package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var firstValue: Double =0.0
    var operator: String = ""
    //private var contador: Int = 15
    //var gravedad: Double=9.81

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        binding.buttonDelete.setOnClickListener(){
            binding.pantalla.setText(binding.pantalla.text.dropLast(1))
        }

        binding.buttonC.setOnClickListener(){
            binding.pantalla.text.clear()
        }

        binding.igual.setOnClickListener(){
            when(operator){
                "Multiplicacion" ->{
                    binding.pantalla.setText("${firstValue*binding.pantalla.text.toString().toDouble()}")
                }
                "Division" ->{
                    binding.pantalla.setText("${firstValue/binding.pantalla.text.toString().toDouble()}")
                }
                "suma"->{
                    binding.pantalla.setText("${firstValue+binding.pantalla.text.toString().toDouble()}")
                }
                "resta"->{
                    binding.pantalla.setText("${firstValue-binding.pantalla.text.toString().toDouble()}")
                }

                else -> {""}
            }
        }

    }

    fun porcen(view: View){
        binding.pantalla.setText("${binding.pantalla.text.toString().toDouble()/100}")
    }

    fun presionoUnBoton(view: View){
        //Toast.makeText(this,"test", Toast.LENGTH_SHORT).show()
        val button = view as Button

        when (button.id){
            //condicion para decimales
                binding.punto.id->{
                    if(!binding.pantalla.text.contains('.')){
                        binding.pantalla.text.append(".")
                    }
                }
            binding.button0.id ->{ binding.pantalla.text.append("0")}
            binding.button1.id ->{ binding.pantalla.text.append("1")}
            binding.button2.id ->{ binding.pantalla.text.append("2")}
            binding.button3.id ->{ binding.pantalla.text.append("3")}
            binding.button4.id ->{ binding.pantalla.text.append("4")}
            binding.button5.id ->{ binding.pantalla.text.append("5")}
            binding.button6.id ->{ binding.pantalla.text.append("6")}
            binding.button7.id ->{ binding.pantalla.text.append("7")}
            binding.button8.id ->{ binding.pantalla.text.append("8")}
            binding.button9.id ->{ binding.pantalla.text.append("9")}
            else -> {Toast.makeText(this,"else",Toast.LENGTH_SHORT).show()}
        }
    }

    fun operatorclick(view: View){
        val button = view as Button
        operator = when(button.id){
            binding.multiplica.id -> {"Multiplicacion"}
            binding.divide.id->{"Division"}
            binding.suma.id->{"suma"}
            binding.menos.id->{"resta"}
            else->{""}
        }
        firstValue = binding.pantalla.text.toString().toDouble()

        binding.pantalla.text.clear()
    }
}