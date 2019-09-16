package com.ravi.enduser.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ravi.enduser.R
import com.squareup.picasso.Picasso


import java.util.ArrayList

import me.toptas.rssconverter.RssItem
import org.jsoup.Jsoup

/**
 * Adapter for listing [RssItem]
 */
internal class RssItemsAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<RssItemsAdapter.ViewHolder>() {

    private val itemList = ArrayList<RssItem>()

    /**
     * Set [RssItem] list
     *
     * @param items item list
     */
    fun setItems(items: List<RssItem>) {
        itemList.clear()
        itemList.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_rss_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.apply {
            textTitle.text = item.title
            textPubDate.text = item.publishDate

            val doc = Jsoup.parse(item.description)
            val imageElement = doc.select("img").first()

            val absoluteUrl = imageElement.absUrl("src")  //absolute URL on src

//            val srcValue = imageElement.attr("src")

            Log.d("rss_descripton","/"+absoluteUrl+"/");
            if (absoluteUrl != null) {
                Picasso.get()
                        .load(absoluteUrl)
                        .fit()
                        .centerCrop()
                        .into(imageThumb)

            }
            itemView.setOnClickListener {
                listener.onItemSelected(item)
            }

            itemView.tag = item
        }
    }

    override fun getItemCount() = itemList.size

    internal interface OnItemClickListener {
        fun onItemSelected(rssItem: RssItem)
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val textPubDate: TextView = itemView.findViewById(R.id.tvPubDate)
        val imageThumb: ImageView = itemView.findViewById(R.id.ivThumb)
        val llTextContainer: RelativeLayout = itemView.findViewById(R.id.llTextContainer)
    }
}
