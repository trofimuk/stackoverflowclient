package com.example.domain.questions

import com.example.data.questions.QuestionsGateway
import com.example.data.questions.QuestionsResponse
import io.reactivex.Observable
import io.reactivex.functions.Function

class QuestionsUseCaseImpl(private val questionsGateway: QuestionsGateway)
    : QuestionsUseCase{

    override fun getQuestions(tagName: String): Observable<QuestionsEntity> {
        return questionsGateway.getQuestions(tagName).map(QuestionsDataMapper())
    }

    private inner class QuestionsDataMapper : Function<QuestionsResponse, QuestionsEntity> {

        override fun apply(response: QuestionsResponse): QuestionsEntity {
            return QuestionsEntity(response.items)
        }
    }
}