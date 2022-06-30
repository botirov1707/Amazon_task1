package dev.ogabek.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon_task1.Essential
import com.example.amazon_task1.R

class EssentialAdapter(var items: List<Essential>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_essential, parent, false)
        return EssentialViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val essential: Essential = items[position]
        if (holder is EssentialViewHolder) {
            holder.image.setImageResource(essential.image)
            holder.title.text = essential.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private class EssentialViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.iv_image)
        var title: TextView = view.findViewById(R.id.tv_title)

    }

}