package com.example.memorama

import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.example.games.R
import kotlinx.android.synthetic.main.renglon.view.*

class MemoramaAdapter(val chips: ArrayList<Chip>):


    RecyclerView.Adapter<MemoramaAdapter.ChipViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChipViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.renglon, p0, false)
        return ChipViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  chips.size
    }

    var dosAbiertos = 0
    var presionados = ArrayList<ImageView>()
    var presionadosChips = ArrayList<Chip>()
    var paresEncontrados = 0

    override fun onBindViewHolder(p0: ChipViewHolder, p1: Int) {
        p0.imageView.setImageResource(chips[p1].idImage)
        p0.imageView.setOnClickListener {
            p0.imageView.setImageResource(chips[p1].imagen1)
            presionados.add(p0.imageView)
            presionadosChips.add(chips[p1])
            dosAbiertos++

            if (dosAbiertos == 2) {
                Handler().postDelayed(Runnable {
                    if(presionadosChips[0].imagen1 == presionadosChips[1].imagen1) {
                        paresEncontrados++
                        if(paresEncontrados == 8) {
                            Toast.makeText(it.context, "Ganasteeee", Toast.LENGTH_LONG).show()
                        }
                        for(presionado in presionados) {
                            //Quita las que ya adivinaste
                            presionado.setImageResource(0)
                        }
                    }
                    else {
                        for(presionado in presionados) {
                            //si no fueron iguales las tapa
                            presionado.setImageResource(R.mipmap.ic_launcher)
                        }
                    }
                    dosAbiertos = 0
                    presionados.clear()
                    presionadosChips.clear()}
                    , 500)
            }
        }
    }


    inner class ChipViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val imageView = item.findViewById<ImageView>(R.id.chip);
    }


}
