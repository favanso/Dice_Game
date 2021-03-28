package com.famsbprog.testedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
      lateinit var turnValueOutput: TextView
      lateinit var turnPlayerOutput: TextView
      lateinit var player1Output : TextView
      lateinit var player2Output : TextView
      var player1Total = 0
      var player2Total = 0
      var turnTotal = 0
      var currentPlayer = "P1"
      lateinit var imgDice1 : ImageView
      lateinit var imgDice2 : ImageView
      lateinit var hButton : Button
      lateinit var rButton: Button
      lateinit var winner : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        turnValueOutput = findViewById(R.id.turnValue)
        turnPlayerOutput = findViewById(R.id.cPlayer)
        player1Output  = findViewById(R.id.p1Total)
        player2Output  = findViewById(R.id.p2total)
        imgDice1 = findViewById(R.id.diceOne)
        imgDice2  = findViewById(R.id.diceTwo)
        hButton = findViewById(R.id.btnHold)
        rButton = findViewById(R.id.btnRoll)
        winner  = findViewById(R.id.winnerText)

    }//End On Create

     fun rollDice(view: View) {
         var dice1 = Dice(6)
         var dice2 = Dice(6)
         var diceRoll1 = dice1.roll()
         var diceRoll2 = dice2.roll()
         turnTotal = diceRoll1 + diceRoll2

         turnValueOutput.text = turnTotal.toString()

          when(diceRoll1){
              1->imgDice1.setImageResource(R.drawable.d1)
              2->imgDice1.setImageResource(R.drawable.d2)
              3->imgDice1.setImageResource(R.drawable.d3)
              4->imgDice1.setImageResource(R.drawable.d4)
              5->imgDice1.setImageResource(R.drawable.d5)
              6->imgDice1.setImageResource(R.drawable.d6)
          }

          when(diceRoll2){
              1->imgDice2.setImageResource(R.drawable.d1)
              2->imgDice2.setImageResource(R.drawable.d2)
              3->imgDice2.setImageResource(R.drawable.d3)
              4->imgDice2.setImageResource(R.drawable.d4)
              5->imgDice2.setImageResource(R.drawable.d5)
              6->imgDice2.setImageResource(R.drawable.d6)
          }

         if ((diceRoll1 == 1 && diceRoll2 != 1)||(diceRoll1 != 1 && diceRoll2 == 1))
         {
             if(currentPlayer=="P1")
             {
                 turnTotal = 0
                 turnValueOutput.text = turnTotal.toString()
                 currentPlayer = "P2"
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(true)
             }

             else
             {
                 turnTotal = 0
                 turnValueOutput.text = turnTotal.toString()
                 currentPlayer = "P1"
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(true)
             }

         }

         else if(diceRoll1 == 1 && diceRoll2 == 1)
         {
             if(currentPlayer=="P1")
             {
                 turnTotal = 0
                 turnValueOutput.text = turnTotal.toString()
                 player1Total = 0
                 player1Output.text = player1Total.toString()
                 currentPlayer = "P2"
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(true)
             }

             else{
                 turnTotal = 0
                 turnValueOutput.text = turnTotal.toString()
                 player2Total = 0
                 player2Output.text = player2Total.toString()
                 currentPlayer = "P2"
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(true)
             }
         }

         else if (diceRoll1 != 1 && diceRoll2 != 1 && diceRoll1 == diceRoll2)
         {
             if(currentPlayer=="P1")
             {
                 turnTotal = diceRoll1 + diceRoll2
                 turnValueOutput.text = turnTotal.toString()
                 player1Total += turnTotal
                 player1Output.text = player1Total.toString()
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(false)
             }
             else{
                 turnTotal = diceRoll1 + diceRoll2
                 turnValueOutput.text = turnTotal.toString()
                 player2Total += turnTotal
                 player2Output.text = player2Total.toString()
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(false)
             }
         }

         else
         {
             if(currentPlayer=="P1"){
                 turnTotal = diceRoll1 + diceRoll2
                 turnValueOutput.text = turnTotal.toString()
                 player1Total += turnTotal
                 player1Output.text = player1Total.toString()
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(true)
             }
             else{
                 turnTotal = diceRoll1 + diceRoll2
                 turnValueOutput.text = turnTotal.toString()
                 player2Total += turnTotal
                 player2Output.text = player2Total.toString()
                 turnPlayerOutput.text = currentPlayer
                 hButton.setEnabled(true)
             }

         }

         if (player1Total >= 50){
             winner.text = "Player 1 Wins"
             rButton.setEnabled(false)
             hButton.setEnabled(false)
         }
         else if (player2Total >= 50){
             winner.text = "Player 2 Wins"
             rButton.setEnabled(false)
             hButton.setEnabled(false)
         }

   }// End RollDice

   fun holdTotal(view: View)
   {
      if(currentPlayer == "P1"){

             currentPlayer = "P2"
             turnPlayerOutput.text = currentPlayer

         }
         else{
             currentPlayer = "P1"
             turnPlayerOutput.text = currentPlayer
         }
       imgDice1.setImageResource(R.drawable.d1)
       imgDice2.setImageResource(R.drawable.d1)
     } //end HoldTotal

    fun resetAll(view: View)
    {
        imgDice1.setImageResource(R.drawable.d1)
        imgDice2.setImageResource(R.drawable.d1)
        turnTotal = 0
        turnValueOutput.text = turnTotal.toString()
        player1Total = 0
        player1Output.text = player1Total.toString()
        player2Total = 0
        player2Output.text = player2Total.toString()
        currentPlayer = "P1"
        turnPlayerOutput.text = currentPlayer
        hButton.setEnabled(true)
        rButton.setEnabled(true)
        winner.text = ""
    }


} //EndMainAct




