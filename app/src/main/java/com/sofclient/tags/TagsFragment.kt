package com.sofclient.tags

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.tags.Tag
import com.example.domain.tags.TagsEntity
import com.sofclient.R
import com.sofclient.adapters.TagsPagedAdapter
import com.sofclient.base.BaseFragment
import com.sofclient.tags.datasoutce.TagsDataSourceFactory
import kotlinx.android.synthetic.main.tags_fragment.*

class TagsFragment : BaseFragment(){

    private lateinit var tagsViewModel: TagsViewModel

    private lateinit var tagsAdapter: TagsPagedAdapter

    override fun getLayoutId() = R.layout.tags_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initViewModel() {
        tagsViewModel = ViewModelProvider(this).get(TagsViewModel::class.java)
    }

    private fun initUserAdapter(){
        rcvTags.layoutManager = LinearLayoutManager(activity)
        tagsAdapter = TagsPagedAdapter()
        rcvTags.adapter = tagsAdapter
    }

    override fun setListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initUi() {
        initViewModel()
        initUserAdapter()
        populateUserAdapter()
        //setListeners()
    }


    private fun populateUserAdapter(){
        tagsViewModel.tagsListLiveData
            .observe(this, Observer<PagedList<Tag>> { tagsAdapter.submitList(it) })
    }
}