package com.sofclient.tags

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.data.tags.Tag
import com.example.domain.tags.TagsUseCase
import com.sofclient.base.BaseViewModel
import com.sofclient.tags.datasoutce.TagsDataSourceFactory
import org.koin.core.KoinComponent
import org.koin.core.inject

class TagsViewModel : BaseViewModel(), KoinComponent{

    val tagsListLiveData: LiveData<PagedList<Tag>>

    private val tagsInteractor : TagsUseCase by inject()

    private val sourceFactory: TagsDataSourceFactory = TagsDataSourceFactory(tagsInteractor)

    private val pageSize = 20

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()

        tagsListLiveData = LivePagedListBuilder<Long, Tag>(sourceFactory, config).build()
    }
}