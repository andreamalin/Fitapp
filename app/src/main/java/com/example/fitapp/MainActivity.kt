package com.example.fitapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_running.*

class MainActivity : AppCompatActivity() {
    //Initializing
    private var actualLaps = 0
    private lateinit var buttonLaps: Button
    private lateinit var buttonRefresh: Button
    private var lapsNum = 0
    lateinit var prizeImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running)
        //Defining values
        buttonLaps = findViewById(R.id.buttonLaps)
        buttonRefresh = findViewById(R.id.buttonRefresh)
        prizeImage = findViewById(R.id.noBackground)
        lapsNum = intent.getIntExtra("lapsNumber", 0)

        //Laps button
        buttonLaps.setOnClickListener {
            sumLap()
            textLaps.text = actualLaps.toString()

        }
        //Refresh button
        buttonRefresh.setOnClickListener {
            refreshLaps()
        }

    }
    //Showing actual lap
    fun sumLap(){
        if (this.actualLaps == (this.lapsNum - 1)){
            //When actual lap and laps number entered are the same
            this.prizeImage.setImageResource(R.drawable.trofeo) //show first place price
            actualLaps++ //Add one lap on the text view
            //Showing complete laps text
            Toast.makeText(this@Running, "Terminaste de correr!", Toast.LENGTH_SHORT).show()
            //
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)   //Starting next activity
        } else {
            this.actualLaps++ //Add one lap on the text view
            //Showing lacking laps
            Toast.makeText(this@Running, """Faltan ${lapsNum - actualLaps} vueltas""", Toast.LENGTH_SHORT).show()
        }
    }
    //Refreshing progress
    fun refreshLaps(){
        actualLaps = 0
        textLaps.text = actualLaps.toString()
        this.prizeImage.setImageResource(R.drawable.first) //show empty image
    }
}
