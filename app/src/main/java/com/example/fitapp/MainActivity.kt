package com.example.fitapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Initializing
    private var actualLaps = 0 //Actual lap
    private var maxLaps = 20 //Max of laps
    private lateinit var buttonLaps: Button
    private lateinit var buttonRefresh: Button
    lateinit var prizeImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Defining values
        buttonLaps = findViewById(R.id.buttonLaps)
        buttonRefresh = findViewById(R.id.buttonRefresh)
        prizeImage = findViewById(R.id.noBackground)

        //Laps button
        buttonLaps.setOnClickListener {
            sumLap()
            showPrize()
        }
        //Refresh button
        buttonRefresh.setOnClickListener {
            refreshLaps()
        }

    }
    //Showing actual lap
    private fun sumLap(){
        //Only sum lap if there are less than 20 actual laps
        if (actualLaps < 20){
            if (this.actualLaps == (this.maxLaps - 1)){
                actualLaps++ //Add one lap on the text view
                //Showing complete laps text
                Toast.makeText(this@MainActivity, "Terminaste de correr!", Toast.LENGTH_SHORT).show()
            } else {
                this.actualLaps++ //Add one lap on the text view
                //Showing lacking laps
                Toast.makeText(this@MainActivity, """Faltan ${maxLaps - actualLaps} vueltas""", Toast.LENGTH_SHORT).show()
            }
            textLaps.text = actualLaps.toString() //Showing actual lap
        } else {
            //Showing the counting is on max
            Toast.makeText(this@MainActivity, "Llegaste al maximo", Toast.LENGTH_SHORT).show()
        }
    }
    //Showing prize
    private fun showPrize(){
        if (actualLaps == 10) {
            this.prizeImage.setImageResource(R.drawable.second) //show first place price
        } else if (actualLaps == 20) {
            this.prizeImage.setImageResource(R.drawable.first) //show first place price
        }
    }
    //Refreshing progress
    private fun refreshLaps(){
        actualLaps = 0
        textLaps.text = actualLaps.toString()
        this.prizeImage.setImageResource(R.drawable.noback) //show empty image
        Toast.makeText(this@MainActivity, "Comienza de nuevo!", Toast.LENGTH_SHORT).show() //Showing refresh message
    }
}
