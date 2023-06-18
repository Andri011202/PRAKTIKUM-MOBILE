package com.andrirahmadani.animaldri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class DetailTanamanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tanaman)

        val namaDiLayout = findViewById<TextView>(R.id.tv_nama)
        val ilmiahDiLayout = findViewById<TextView>(R.id.tv_nama_ilmiah)
        val deskripsiDiLayout = findViewById<TextView>(R.id.tv_item_description)
        val filumDiLayout = findViewById<TextView>(R.id.nama_filum_teks)
        val habitatDiLayout = findViewById<TextView>(R.id.habitat_teks)
        val spesiesDiLayout = findViewById<TextView>(R.id.nama_spesies_teks)
        val gambarDiLayout = findViewById<ImageView>(R.id.img_item_photo)
        val button = findViewById<Button>(R.id.button_id)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        //get data from putExtra
        var intent = intent
        val nama = intent.getStringExtra("Nama")
        val ilmiah = intent.getStringExtra("Ilmiah")
        val gambar = intent.getIntExtra("Gambar", 0)
        val deskripsi = intent.getStringExtra("Deskripsi")
        val filum = intent.getStringExtra("Filum")
        val habitat = intent.getStringExtra("Habitat")
        val spesies = intent.getStringExtra("Spesies")

        actionBar.setTitle(nama)
        namaDiLayout.text = nama
        ilmiahDiLayout.text = ilmiah
        filumDiLayout.text = filum
        spesiesDiLayout.text = spesies
        habitatDiLayout.text = habitat

        deskripsiDiLayout.text = deskripsi
        gambarDiLayout.setImageResource(gambar)
//        ilmiahDiLayout.text = ilmiah



    }
}