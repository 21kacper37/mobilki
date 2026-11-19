package com.technischools.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var czyOdkurzaczWlaczony = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numerPraniaEditText = findViewById<EditText>(R.id.numerPraniaEditText)
        val zatwierdzButton = findViewById<Button>(R.id.zatwierdzButton)
        val numerPraniaTextView = findViewById<TextView>(R.id.numerPraniaTextView)

        val odkurzaczButton = findViewById<Button>(R.id.odkurzaczButton)
        val odkurzaczStatusTextView = findViewById<TextView>(R.id.odkurzaczStatusTextView)

        zatwierdzButton.setOnClickListener {
            val wprowadzonyTekst = numerPraniaEditText.text.toString().trim()
            val numerPrania = wprowadzonyTekst.toIntOrNull()

            if (numerPrania != null && numerPrania in 1..12) {
                numerPraniaTextView.text = "Numer prania: $numerPrania"
            }
        }

        odkurzaczButton.setOnClickListener {
            czyOdkurzaczWlaczony = !czyOdkurzaczWlaczony
            if (czyOdkurzaczWlaczony) {
                odkurzaczButton.text = "Wyłącz"
                odkurzaczStatusTextView.text = "Odkurzacz włączony"
            } else {
                odkurzaczButton.text = "Włącz"
                odkurzaczStatusTextView.text = "Odkurzacz wyłączony"
            }
        }
    }
}
