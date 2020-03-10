package com.sofclient.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.data.questions.Question
import com.example.data.tags.Tag
import com.example.domain.questions.QuestionsEntity
import com.example.domain.questions.QuestionsUseCase
import com.example.domain.tags.TagsUseCase
import com.sofclient.base.BaseViewModel
import com.sofclient.questions.datasource.QuestionsDataSourceFactory
import com.sofclient.tags.datasoutce.TagsDataSourceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class  QuestionsViewModel : BaseViewModel(), KoinComponent {

    private val questionsInteractor: QuestionsUseCase by inject()

    val questionsListLiveData: LiveData<PagedList<Question>>

    private var tagName: String? = null

    private val sourceFactory: QuestionsDataSourceFactory =
        QuestionsDataSourceFactory(questionsInteractor, tagName!!)

    private val pageSize = 20

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()

        questionsListLiveData = LivePagedListBuilder<Long, Question>(sourceFactory, config).build()
    }

    fun setTagName(tagName : String){
        this.tagName = tagName
    }
}