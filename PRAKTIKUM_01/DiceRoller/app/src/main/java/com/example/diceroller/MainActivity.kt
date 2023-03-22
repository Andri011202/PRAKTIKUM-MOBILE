package com.example.diceroller
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Letak button
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener pada saat ketika pengguna menekan tombol
        rollButton.setOnClickListener { rollDice() }

        //Pada saat aplikasi dibuka
        rollDice()
    }

    /**
     * Dadu bergulir, kemudian update perubahan layar berdasarkan hasil gulir.
     */
    private fun rollDice() {
        // Objek untuk dadu 1
        val dice = Dice(6)

        //Objek untuk dadu 2
        val dice2 = Dice(6)

        //Panggil method roll() untuk bergulir
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Panggil ImageView di layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll 1
        val drawableResourceForDice1 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Determine which drawable resource ID to use based on the dice roll 1
        val drawableResourceForDice2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update ImageView drawable resource ID
        diceImage.setImageResource(drawableResourceForDice1)
        diceImage2.setImageResource(drawableResourceForDice2)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        luckyCheck(diceRoll,diceRoll2)
    }

    //Fungsi untuk mencek nilai kedua dadu apakah sama
    private fun luckyCheck(dadu1: Int, dadu2: Int) {
        if (dadu1 == dadu2) {
            Toast.makeText(this, "Selamat Anda Mendapatkan Dadu Double!", Toast.LENGTH_SHORT).show()
        } else if (dadu1 < dadu2) Toast.makeText(this, "Anda Belum Beruntung", Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {
    /**
     * Fungsi untuk menggulirkan dadu dengan mengembalikan nilai int
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}