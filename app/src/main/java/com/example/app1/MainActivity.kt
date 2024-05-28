package com.example.app1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var displayArea: TextView
    private var currentColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayArea = findViewById(R.id.displayArea)

        val btnRed: Button = findViewById(R.id.btnRed)
        val btnGreen: Button = findViewById(R.id.btnGreen)
        val btnBlue: Button = findViewById(R.id.btnBlue)
        val btnYellow: Button = findViewById(R.id.btnYellow)
        val btnCyan: Button = findViewById(R.id.btnCyan)
        val btnMagenta: Button = findViewById(R.id.btnMagenta)
        val btnOrange: Button = findViewById(R.id.btnOrange)
        val btnPurple: Button = findViewById(R.id.btnPurple)
        val btnBrown: Button = findViewById(R.id.btnBrown)
        val btnPink: Button = findViewById(R.id.btnPink)
        val btnWhite: Button = findViewById(R.id.btnWhite)
        val btnBlack: Button = findViewById(R.id.btnBlack)

        btnRed.setOnClickListener { mixColor(Color.RED) }
        btnGreen.setOnClickListener { mixColor(Color.GREEN) }
        btnBlue.setOnClickListener { mixColor(Color.BLUE) }
        btnYellow.setOnClickListener { mixColor(Color.YELLOW) }
        btnCyan.setOnClickListener { mixColor(Color.CYAN) }
        btnMagenta.setOnClickListener { mixColor(Color.MAGENTA) }
        btnOrange.setOnClickListener { mixColor(Color.parseColor("#FFA500")) }
        btnPurple.setOnClickListener { mixColor(Color.parseColor("#800080")) }
        btnBrown.setOnClickListener { mixColor(Color.parseColor("#A52A2A")) }
        btnPink.setOnClickListener { mixColor(Color.parseColor("#FFC0CB")) }
        btnWhite.setOnClickListener { mixColor(Color.parseColor("#FFFFFF")) }
        btnBlack.setOnClickListener { mixColor(Color.BLACK) }

        val clearButton = findViewById<Button>(R.id.btnClear)
        clearButton.setOnClickListener { clearColor() }

        val infoButton = findViewById<ImageButton>(R.id.btnInfo)
        infoButton.setOnClickListener { showInfoDialog() }
    }

    private fun mixColor(color: Int) {
        currentColor = blendColors(currentColor, color)
        displayArea.setBackgroundColor(currentColor)
        updateDisplayColor(currentColor)
    }

    private fun blendColors(color1: Int, color2: Int): Int {
        val r1 = Color.red(color1)
        val g1 = Color.green(color1)
        val b1 = Color.blue(color1)

        val r2 = Color.red(color2)
        val g2 = Color.green(color2)
        val b2 = Color.blue(color2)

        val r = (r1 + r2) / 2
        val g = (g1 + g2) / 2
        val b = (b1 + b2) / 2

        return Color.rgb(r, g, b)
    }

    private fun clearColor() {
        currentColor = Color.WHITE
        displayArea.setBackgroundColor(currentColor)
        displayArea.text = colorToHex(currentColor)
    }

    private fun updateDisplayColor(color: Int) {
        displayArea.setBackgroundColor(color)
        displayArea.text = colorToHex(color)
    }

    private fun colorToHex(color: Int): String {
        return String.format("#%06X", 0xFFFFFF and color)
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
            .setTitle("About Color Mixer")
            .setMessage("This app allows you to mix colors by clicking on different color buttons. The mixed color is displayed along with its hexadecimal value. Use the 'Clear' button to reset the color.")
            .setPositiveButton("OK", null)
            .show()
    }
}