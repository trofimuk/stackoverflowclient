package com.example.data.questions


import io.reactivex.Observable

interface QuestionsGateway {

    fun getQuestions(tagName : String) : Observable<QuestionsResponse>
}