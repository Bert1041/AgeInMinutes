package com.ripper.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ripper.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener { view ->
            clickDatePicker(view)
            Toast.makeText(
                this, "Buttom works", Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun clickDatePicker(view: View) {
        val myCalendar: Calendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, sYear, sMonth, sDayOfMonth ->
                Toast.makeText(this,
                    "The chosen year is $sYear The day is $sDayOfMonth, The month is $sMonth", Toast.LENGTH_LONG ).show()

                val selectedDate = "$sDayOfMonth/${sMonth + 1}/$sYear"

                binding.textView6.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val selectedDateInMin= theDate!!.time/60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMin = currentDate!!.time/60000
                val difference = currentDateInMin - selectedDateInMin




                binding.textView7.text = difference.toString()


               // Toast.makeText(this, "$theDate", Toast.LENGTH_LONG).show()

            },
            year,
            month,
            day
        ).show()

    }
}