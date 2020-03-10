package com.sofclient.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.tags.Tag
import com.sofclient.R
import kotlinx.android.synthetic.main.tags_item.view.*

class TagHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun bindTo(tag: Tag?) {
        itemView.tvName.text = tag?.name
        itemView.tvCount.text = tag?.count
    }

    companion object {
        fun create(parent: ViewGroup): TagHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.tags_item, parent, false)
            return TagHolder(view)
        }
    }
}