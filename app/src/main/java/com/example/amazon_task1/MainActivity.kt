package com.example.amazon_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon_task1.adapter.ImageAdapter
import dev.ogabek.kotlin.adapter.EssentialAdapter
import dev.ogabek.kotlin.model.Image

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rv_fashion: RecyclerView
    private lateinit var rv_popular: RecyclerView
    private lateinit var fashion: LinearLayout
    private lateinit var popular: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.rv_essential)
        rv_fashion = findViewById(R.id.rv_ll_fashion)
        rv_popular = findViewById(R.id.rv_ll_popular)
        fashion = findViewById(R.id.ll_fashion)
        popular = findViewById(R.id.ll_popular)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(manager)
        rv_fashion.setLayoutManager(GridLayoutManager(this, 2))
        rv_popular.setLayoutManager(GridLayoutManager(this, 2))
        rv_popular.setAdapter(ImageAdapter(this, getPopular()))
        rv_fashion.setAdapter(ImageAdapter(this, getFashion()))
        refreshAdapter(recyclerView, essentials as List<Essential>)
        setLinearHeight(fashion)
        setLinearHeight(popular)
    }

    private fun getFashion(): List<Image> {
        val images: MutableList<Image> = ArrayList<Image>()
        images.add(Image(R.drawable.sneaker_1))
        images.add(Image(R.drawable.sneaker_2))
        images.add(Image(R.drawable.sneaker_3))
        images.add(Image(R.drawable.sneaker_2))
        return images
    }

    private fun getPopular(): List<Image> {
        val images: MutableList<Image> = ArrayList<Image>()
        images.add(Image(R.drawable.camera_1))
        images.add(Image(R.drawable.camera_2))
        images.add(Image(R.drawable.camera_3))
        images.add(Image(R.drawable.camera_4))
        return images
    }

    private fun setLinearHeight(layout: LinearLayout?) {
        //Get Screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPixels = displayMetrics.heightPixels

        //Change pixel to dp
        val heightInDp = (heightPixels / resources.displayMetrics.density).toInt()

        //Set layout with programmatically
        val params = layout!!.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    fun setImageHeight(image: ImageView) {
        //Get Screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPixels = displayMetrics.heightPixels

        //Change pixel to dp
        val heightInDp = (heightPixels / resources.displayMetrics.density).toInt()

        //Set layout with programmatically
        val params = image.layoutParams
        params.height = heightInDp / 2 - 52
        image.layoutParams = params
    }

    private fun refreshAdapter(recyclerView: RecyclerView?, essentials: List<Essential>) {
        val adapter = EssentialAdapter(essentials)
        recyclerView!!.adapter = adapter
    }

    private val essentials: List<Any>
        private get() {
            val essentials: MutableList<Essential> = ArrayList<Essential>()
            essentials.add(Essential("Oculus", R.drawable.game))
            essentials.add(Essential("Game", R.drawable.game))
            essentials.add(Essential("Mobile", R.drawable.game))
            return essentials
        }
}