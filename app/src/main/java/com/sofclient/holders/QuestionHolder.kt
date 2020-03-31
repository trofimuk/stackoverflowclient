package com.sofclient.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.questions.Question
import com.sofclient.R
import kotlinx.android.synthetic.main.questions_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class QuestionHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(question: Question?){
        itemView.tvTitle.text = question?.title
        itemView.tvName.text = question?.owner?.authorName
        itemView.tvDate.text = convertLongToTime(question?.date!!.toLong())
    }

    companion object {
        fun create(parent: ViewGroup): QuestionHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.questions_item, parent,false)
            return QuestionHolder(view)
        }
    }

    private fun convertLongToTime(time: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(Date(time * 1000))
    }
}