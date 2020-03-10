package com.sofclient.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.questions.Question
import com.sofclient.R
import kotlinx.android.synthetic.main.questions_item.view.*

class QuestionHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(question: Question?){
        itemView.tvTitle.text = question?.title
        itemView.tvId.text = question?.question_id.toString()
    }

    companion object {
        fun create(parent: ViewGroup): QuestionHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.questions_item, parent,false)
            return QuestionHolder(view)
        }
    }
}