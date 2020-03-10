package com.sofclient.questions.datasource

import androidx.paging.ItemKeyedDataSource
import com.example.data.questions.Question
import com.example.data.utils.StorageUtils
import com.example.domain.questions.QuestionsEntity
import com.example.domain.questions.QuestionsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class QuestionsDataSource(
    private val questionsInteractor: QuestionsUseCase
) :
    ItemKeyedDataSource<Long, Question>(), KoinComponent {

    val storage : StorageUtils by inject()
    companion object {
        val allCompositeDisposable: MutableList<Disposable> = arrayListOf()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Question>
    ) {
        val disposable = questionsInteractor.getQuestions(storage.getTagName())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { questionsEntity ->
                callback.onResult(transform(questionsEntity))
            }
        allCompositeDisposable.add(disposable)
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Question>) {
        val disposable = questionsInteractor.getQuestions(storage.getTagName())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { questionsEntity ->
                callback.onResult(transform(questionsEntity))
            }
        allCompositeDisposable.add(disposable)
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Question>) {
        // ignored, since we only ever append to our initial load
    }

    override fun getKey(item: Question): Long = item.question_id

    private fun transform(questionsEntity: QuestionsEntity): MutableList<Question> {
        val questionList = ArrayList<Question>()
        questionsEntity.items.forEach {
            questionList.add(Question(it.question_id, it.title))
        }
        return questionList
    }
}