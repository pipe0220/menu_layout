package com.sena.superheroes

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import com.bumptech.glide.Glide
import com.sena.superheroes.databinding.ActivityDetailHeroBinding

class DetailHero : AppCompatActivity(), PopupMenu.OnMenuItemClickListener,
    android.widget.PopupMenu.OnMenuItemClickListener {
    private lateinit var binding: ActivityDetailHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarDetalle()
        registerForContextMenu(binding.ivAvatar)
        binding.ivAvatar.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun showPopupMenu(it: View?) {
        val popupMenu = android.widget.PopupMenu(this, it)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.show()
    }

    fun cargarDetalle(){
        val nombre: String = intent.getStringExtra("nombre").toString()
        binding.tvSuperhero.text = nombre
        val nombreReal: String = intent.getStringExtra("nombreReal").toString()
        binding.tvRealName.text = nombreReal
        val publisher: String = intent.getStringExtra("publisher").toString()
        binding.tvPublisher.text = publisher
        val fotos= intent.getStringExtra("fotos")

        if (fotos != null) {
            binding.ivAvatar.loadImage(fotos)
        }

    }

    fun ImageView.loadImage(url: String){
        Glide.with(context).load(url).into(this)
    }


    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.ivAvatar-> {
                Toast.makeText(this@DetailHero, "Opcion 1", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item!!)

        }
    }


}