package com.sena.superheroes

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sena.superheroes.adapter.AdapterHorizontal
import com.sena.superheroes.adapter.RecyclerViewAdapter
import com.sena.superheroes.data.DataSource
import com.sena.superheroes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecycler: RecyclerView
    val miAdapter: RecyclerViewAdapter = RecyclerViewAdapter(mutableListOf(), this)
    val miAdapter2: AdapterHorizontal = AdapterHorizontal(mutableListOf(), this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()
        cargarRecycler2()
    }

    fun cargarRecycler() {
        miRecycler = binding.rvSuperHeroes
        miRecycler.setHasFixedSize(true)
        miRecycler.layoutManager = LinearLayoutManager(this)
        miAdapter.RecyclerViewAdapter(DataSource().getSuperHeroes(), this)
        miRecycler.adapter = miAdapter

        miAdapter.setItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity, "se selecciono el item: $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, DetailHero::class.java)
                intent.putExtra("nombre", DataSource().getSuperHeroes().get(position).nombre)
                intent.putExtra(
                    "nombreReal",
                    DataSource().getSuperHeroes().get(position).nombreReal
                )
                intent.putExtra("publisher", DataSource().getSuperHeroes().get(position).publisher)
                intent.putExtra("fotos", DataSource().getSuperHeroes().get(position).foto)
                startActivity(intent)
            }

        })


    }
    fun cargarRecycler2() {
        miRecycler = binding.rvSuperHeroes2
        miRecycler.setHasFixedSize(true)
        miRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        miAdapter2.AdapterHorizontal(DataSource().getSuperHeroes(), this)
        miRecycler.adapter = miAdapter2

        miAdapter2.setItemClickListener(object : AdapterHorizontal.onItemClickListener {
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity, "se selecciono el item: $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, DetailHero::class.java)
                intent.putExtra("nombre", DataSource().getSuperHeroes().get(position).nombre)
                intent.putExtra(
                    "nombreReal",
                    DataSource().getSuperHeroes().get(position).nombreReal
                )
                intent.putExtra("publisher", DataSource().getSuperHeroes().get(position).publisher)
                intent.putExtra("fotos", DataSource().getSuperHeroes().get(position).foto)
                startActivity(intent)
            }

        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_1 -> {
                // Maneja la selección de la Opción 1
                true
            }
            R.id.menu_item_2 -> {
                // Maneja la selección de la Opción 2
                true
            }
            R.id.menu_item_3 -> {
                // Maneja la selección de la Opción 3
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
    fun View.showPopupMenu(
        menuRes: Int,
        onMenuItemClick: (MenuItem) -> Boolean,
        gravity: Int = Gravity.NO_GRAVITY,
    ) {
        val popupMenu = PopupMenu(context, this)
        popupMenu.gravity = gravity
        popupMenu.menuInflater.inflate(menuRes, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            onMenuItemClick(menuItem)
        }
        popupMenu.show()

        miRecycler.setOnLongClickListener {
            it.showPopupMenu(
                R.menu.popup_menu,
                onMenuItemClick = { menuItem ->
                    when (menuItem.itemId) {
                        R.id.popup_menu_item_1 -> {
                            true
                        }
                        R.id.popup_menu_item_2 -> {
                            true
                        }
                        R.id.popup_menu_item_3 -> {
                            true
                        }
                        else -> false
                    }
                },
                gravity = Gravity.END,
            )
            true
        }
    }


}