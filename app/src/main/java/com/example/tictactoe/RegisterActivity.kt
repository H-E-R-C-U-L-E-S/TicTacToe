package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var player1et: TextInputEditText
    private lateinit var player1til: TextInputLayout

    private lateinit var player2et: TextInputEditText
    private lateinit var player2til: TextInputLayout

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        player1et = findViewById(R.id.player_1_et)
        player2et = findViewById(R.id.player_2_et)


        player1til = findViewById(R.id.player_1_til)
        player2til = findViewById(R.id.player_2_til)

        button = findViewById(R.id.start_game_butt)

        button.setOnClickListener {

            val username1 = player1et.text.toString()
            val username2 = player2et.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()


            if (username1.isNotEmpty() && username2.isNotEmpty()) {
                bundle.putString("player1", username1)
                bundle.putString("player2", username2)
            } else {
                bundle.putString("player1", "Player1")
                bundle.putString("player2", "Player2")
            }

            intent.putExtras(bundle)
            startActivity(intent)
            finish()

        }

    }
}