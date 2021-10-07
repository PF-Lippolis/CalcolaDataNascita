package com.example.calcoladatanascita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.calcoladatanascita.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButton()
    }

    private fun setButton() {
        binding.submitButton.setOnClickListener {
            var birthYear:Int? = null
            try {
                birthYear = binding.yearEdit.text.toString().toInt()
            } catch (e: Exception) {
                Toast.makeText(this, "Anno inserito non valido, per piacere riprova", Toast.LENGTH_SHORT).show()
            }
            birthYear?.let{
                val age = Calendar.getInstance().get(Calendar.YEAR) - birthYear
                binding.ageCalculations.text = "Hai $age anni."
                Log.d("ClickListener","Age è $age")
                binding.ageCalculations.visibility = View.VISIBLE
            }
        }
    }
}