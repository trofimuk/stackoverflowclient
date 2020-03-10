package com.example.domain.questions

import io.reactivex.Observable

interface QuestionsUseCase {

    fun getQuestions(tagName: String) : Observable<QuestionsEntity>
}