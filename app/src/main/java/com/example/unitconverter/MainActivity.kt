package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.example.unitconverter.databinding.ActivityMainBinding
const val  MILLILITER_OUNCE = 29.574

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val millimeterTextChangedListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            milliliterToOunce()
        }

    }
    private val ounceTextChangedListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            ounceToMilliliter()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.millilitersValue.addTextChangedListener(millimeterTextChangedListener)
        binding.ouncesValue.addTextChangedListener(ounceTextChangedListener)
    }

    private fun milliliterToOunce() {
        binding.ouncesValue.removeTextChangedListener(ounceTextChangedListener)
        val valueInOunce = binding.millilitersValue.text.toString().toFloatOrNull()?.div(
            MILLILITER_OUNCE)
        if (valueInOunce ==null) {
            binding.ouncesValue.setText("", TextView.BufferType.EDITABLE)
        }else{
            binding.ouncesValue.setText("$valueInOunce", TextView.BufferType.EDITABLE)
        }
        binding.ouncesValue.addTextChangedListener(ounceTextChangedListener)
    }

    private fun ounceToMilliliter() {
        binding.millilitersValue.removeTextChangedListener(millimeterTextChangedListener)
        val valueInMillimeter = binding.ouncesValue.text.toString().toFloatOrNull()?.times(
            MILLILITER_OUNCE)
        if (valueInMillimeter ==null) {
            binding.millilitersValue.setText("", TextView.BufferType.EDITABLE)
        }else{
            binding.millilitersValue.setText("$valueInMillimeter", TextView.BufferType.EDITABLE)
        }
        binding.millilitersValue.addTextChangedListener(millimeterTextChangedListener)

    }

}