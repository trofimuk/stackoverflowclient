package com.sofclient.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.tags.Tag
import com.sofclient.holders.TagHolder

class TagsPagedAdapter(private val onItemClickListener: OnItemClickListener) :
    PagedListAdapter<Tag, RecyclerView.ViewHolder>(TagsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder = TagHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TagHolder).bindTo(getItem(position))
        holder.itemView.setOnClickListener { onItemClickListener.onItemClick(position) }
    }

    companion object {

        private val TagsDiffCallback = object : DiffUtil.ItemCallback<Tag>() {
            override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean =
                oldItem == newItem
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position : Int)
    }
}