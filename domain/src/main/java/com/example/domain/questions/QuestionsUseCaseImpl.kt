package com.example.domain.questions

import com.example.data.questions.QuestionsGateway
import io.reactivex.Observable

class QuestionsUseCaseImpl(private val questionsGateway: QuestionsGateway)
    : QuestionsUseCase{

    override fun getQuestions(): Observable<QuestionsEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}