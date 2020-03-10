package com.sofclient.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.questions.Question
import com.sofclient.holders.QuestionHolder

class QuestionsPagedAdapter : PagedListAdapter<Question, RecyclerView.ViewHolder>(QuestionsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder = QuestionHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as QuestionHolder).bindTo(getItem(position))
    }

    companion object {

        private val QuestionsDiffCallback = object : DiffUtil.ItemCallback<Question>() {
            override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean =
                oldItem.question_id == newItem.question_id

            override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean =
                oldItem == newItem
        }
    }
}