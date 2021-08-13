package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.unitconverter.databinding.ActivityMainBinding
const val  CUBIC_MILLIMETER_OUNCE = 29574

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.millilitersValue.setOnClickListener { CubicMillimeterToOunce() }
        binding.ouncesValue.setOnClickListener { OunceToCubicMillimeter() }

    }

    private fun CubicMillimeterToOunce() {
        val valueInOunce = binding.millilitersValue.text.toString().toFloat().div(
            CUBIC_MILLIMETER_OUNCE)
        binding.ouncesValue.setText("$valueInOunce", TextView.BufferType.EDITABLE)
    }

    private fun OunceToCubicMillimeter() {
        val valueInMillimeter =  binding.ouncesValue.text.toString().toFloat().times(
            CUBIC_MILLIMETER_OUNCE)
        binding.millilitersValue.setText("$valueInMillimeter", TextView.BufferType.EDITABLE)
    }

}