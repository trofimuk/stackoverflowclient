package com.sofclient.questions

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.questions.Question
import com.sofclient.R
import com.sofclient.adapters.QuestionsPagedAdapter
import com.sofclient.base.BaseFragment
import com.sofclient.tags.TagsFragment.Companion.TAG_NAME_VALUE
import kotlinx.android.synthetic.main.questions_fragment.*
import kotlinx.android.synthetic.main.tags_fragment.*

class QuestionsFragment : BaseFragment() {

    private lateinit var questionsViewModel: QuestionsViewModel

    private lateinit var questionsAdapter: QuestionsPagedAdapter

    override fun getLayoutId() = R.layout.questions_fragment

    private fun initViewModel() {
        questionsViewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initQuestionsAdapter(){
        rcvQuestions.layoutManager = LinearLayoutManager(activity)
        questionsAdapter = QuestionsPagedAdapter()
        rcvQuestions.adapter = questionsAdapter
    }

    override fun setListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initUi() {
        initViewModel()
        initQuestionsAdapter()
        populateUserAdapter()

//        val name = arguments?.getString(TAG_NAME_VALUE)
////        name?.let { questionsViewModel.setTagName(it) }

        //setListeners()
    }

    private fun populateUserAdapter(){
        questionsViewModel.questionsListLiveData
            .observe(this, Observer<PagedList<Question>> { questionsAdapter.submitList(it) })
    }
}