package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{CalculateTip()}


    }
    fun CalculateTip(){

    //Calcula um valor
       /* var valorDaTextBox = binding.costOfService.text.toString()
        if(radioButtonTáClicado){
            val porcentagem = 0.20
        }
        if (radioButtonTáClicado){
            val porcentagem = 0.18
        }
        if (radioButtonTáClicado) {
            val porcentagem = 0.15
        }

        var resultado = valorDaTextBox * porcentagem

        var TipTotal = binding.tipResult.text
        TipTotal = resultado*/


        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = formattedTip
    }
}