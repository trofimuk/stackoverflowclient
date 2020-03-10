package com.sofclient.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.questions.QuestionsEntity
import com.example.domain.questions.QuestionsUseCase
import com.sofclient.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class QuestionsViewModel : BaseViewModel(), KoinComponent{

    private val questionsInteractor : QuestionsUseCase by inject()

//    override fun getData(): LiveData<QuestionsEntity> {
//        data = MutableLiveData()
//        disposables += questionsInteractor.getQuestions()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ response ->
//                data.value = response
//            }, {
//            })
//        return data
//    }

}