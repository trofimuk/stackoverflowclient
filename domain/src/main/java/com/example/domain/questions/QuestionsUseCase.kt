package com.example.domain.questions

import io.reactivex.Observable

interface QuestionsUseCase {

    fun getQuestions() : Observable<QuestionsEntity>
}