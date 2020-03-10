package com.sofclient.questions.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.data.questions.Question
import com.example.domain.questions.QuestionsUseCase

class QuestionsDataSourceFactory(
    private val questionsInteractor: QuestionsUseCase
) :
    DataSource.Factory<Long, Question>() {
    private val questionsDataSourceLiveData = MutableLiveData<QuestionsDataSource>()

    override fun create(): DataSource<Long, Question> {
        val questionsDataSource = QuestionsDataSource(questionsInteractor)
        questionsDataSourceLiveData.postValue(questionsDataSource)
        return questionsDataSource
    }
}