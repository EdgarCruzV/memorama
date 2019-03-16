package com.example.memorama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama2.*
import kotlin.random.Random

class MemoramaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama2)
        val rv = recyclerView1
        rv.setHasFixedSize(true)
        var grid = GridLayoutManager(this, 4)
        rv.layoutManager = grid

        val chips = ArrayList<Chip>()
        var posicionesTomadas = ArrayList<Int>()
        val imagenes = arrayListOf(R.drawable.bateria, R.drawable.bateria,  R.drawable.piano, R.drawable.piano,  R.drawable.guitarra,  R.drawable.guitarra,
            R.drawable.rocket,  R.drawable.rocket,  R.drawable.space,  R.drawable.space,  R.drawable.taylor,  R.drawable.taylor,  R.drawable.taylorred,
            R.drawable.taylorred,  R.drawable.taylorrep,  R.drawable.taylorrep)
        //donde se crea las 16 ventanas de juego (donde pinta) la base (imagen de android)
        for(i in 1..16){
            while(true) {
                val posicionChip = Random.nextInt(0,16)
                if (!posicionesTomadas.contains(posicionChip)) {
                    posicionesTomadas.add(posicionChip)
                    chips.add(Chip(R.mipmap.ic_launcher, imagenes[posicionChip]))
                    break
                }
            }
        }


        var  adapter = MemoramaAdapter(chips)
        rv.adapter = adapter

    }
}
