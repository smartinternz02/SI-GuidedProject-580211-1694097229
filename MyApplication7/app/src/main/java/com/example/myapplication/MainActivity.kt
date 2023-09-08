package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate (layoutInflater)
        setContentView(binding.root)
        binding.buttonOne.setOnClickListener { it:View!
            rollDice()
        }
    }
    private fun rollDice()
    {
        val dice = Dice(numSides: 6)

        val dR = when(dice.diceRoll())
        {
            1-> R.drawable.perspective_dice_six_faces_one
            2-> R.drawable.perspective_dice_six_faces_two
            3-> R.drawable.perspective_dice_six_faces_three
            4-> R.drawable.perspective_dice_six_faces_four
            5-> R.drawable.perspective_dice_six_faces_five
            else -> R.drawable.dice_six
        }
        binding.imageView.setImageResource(dR)
    }
}
class Dice(private val numSides: Int)
{
    fun diceRoll(): Int
    {
        return (1..numSides).random()
    }
}