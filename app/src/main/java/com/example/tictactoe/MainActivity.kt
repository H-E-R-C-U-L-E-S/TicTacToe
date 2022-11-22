package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var username1tv: TextView
    private lateinit var username2tv: TextView

    private lateinit var score1tv: TextView
    private lateinit var score2tv: TextView

    private lateinit var reset_button: Button

    private var isX = true
    private var gameOn = true

    private var player1Count = 0
    private var player2Count = 0

    private var username1 = ""
    private var username2 = ""

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username1tv = findViewById(R.id.username_1)
        username2tv = findViewById(R.id.username_2)

        score1tv = findViewById(R.id.p1_score)
        score2tv = findViewById(R.id.p2_score)

        reset_button = findViewById(R.id.reset_button)

        val bundle = intent.extras

        if (bundle != null) {
            username1 = bundle.getString("player1").toString()
            username2 = bundle.getString("player2").toString()
        }

        username1tv.text = username1
        username2tv.text = username2

        reset_button.setOnClickListener {
            resetBoard()
        }

    }

    fun onClick(view: View) {
        if (view is Button) {
            if (gameOn) {

                var number = 0

                when (view.id) {
                    R.id.button1 -> number = 1
                    R.id.button2 -> number = 2
                    R.id.button3 -> number = 3
                    R.id.button4 -> number = 4
                    R.id.button5 -> number = 5
                    R.id.button6 -> number = 6
                    R.id.button7 -> number = 7
                    R.id.button8 -> number = 8
                    R.id.button9 -> number = 9
                }

                playGame(view, number)

            }
        }
    }

    private fun playGame(button: Button, number: Int) {
        if (button.text.isEmpty()) {

            button.isEnabled = false

            if (isX) {
                button.text = "X"
                button.setTextColor(Color.parseColor("#4CAF50"))

                player1.add(number)
                isX = false

                checkWinner()

            } else {
                button.text = "O"
                button.setTextColor(Color.parseColor("#F44336"))

                player2.add(number)
                isX = true

                checkWinner()
            }

        }
    }

    private fun checkWinner() {

        if (player1.contains(1) && player1.contains(2) && player1.contains(3) || player1.contains(4) && player1.contains(
                5
            ) && player1.contains(6) || player1.contains(7) && player1.contains(8) && player1.contains(
                9
            ) || player1.contains(1) && player1.contains(
                4
            ) && player1.contains(7) || player1.contains(2) && player1.contains(5) && player1.contains(
                8
            ) || player1.contains(3) && player1.contains(
                6
            ) && player1.contains(9) || player1.contains(1) && player1.contains(5) && player1.contains(
                9
            ) || player1.contains(3) && player1.contains(
                5
            ) && player1.contains(7)
        ) {
            //თუ X არის გამარჯვებული
            gameOn = false
            player1Count += 1
            score1tv.text = player1Count.toString()

            val builder = AlertDialog.Builder(this)

            builder.setTitle("${username1tv.text} won the game")
            builder.setMessage("Do you want to play again?")
            builder.setPositiveButton("Yes") { _, _ ->
                resetBoard()
            }
            builder.setNegativeButton("No") { _, _ ->
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
            builder.setCancelable(false)
            builder.show()

        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3) || player2.contains(
                4
            ) && player2.contains(
                5
            ) && player2.contains(6) || player2.contains(7) && player2.contains(8) && player2.contains(
                9
            ) || player2.contains(1) && player2.contains(
                4
            ) && player2.contains(7) || player2.contains(2) && player2.contains(5) && player2.contains(
                8
            ) || player2.contains(3) && player2.contains(
                6
            ) && player2.contains(9) || player2.contains(1) && player2.contains(5) && player2.contains(
                9
            ) || player2.contains(3) && player2.contains(
                5
            ) && player2.contains(7)
        ) {
            //თუ O არის გამარჯვებული
            gameOn = false
            player2Count += 1
            score2tv.text = player2Count.toString()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("${username2tv.text} won the game")
            builder.setMessage("Do you want to play again?")
            builder.setPositiveButton("Yes") { _, _ ->
                resetBoard()
            }
            builder.setNegativeButton("No") { _, _ ->
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
            builder.setCancelable(false)
            builder.show()

        } else if (player1.size + player2.size == 9) {
            //თუ ფრეა
            gameOn = false
            score1tv.text = player1Count.toString()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Draw")
            builder.setMessage("Nothing interesting \nDo you want to play again?")
            builder.setCancelable(false)
            builder.setPositiveButton("Yes") { _, _ ->
                resetBoard()
            }
            builder.setNegativeButton("No") { _, _ ->
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
            builder.show()

        }
    }

    private fun resetBoard() {
        player1.clear()
        player2.clear()
        isX = true
        gameOn = true

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""


        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true


    }

}
