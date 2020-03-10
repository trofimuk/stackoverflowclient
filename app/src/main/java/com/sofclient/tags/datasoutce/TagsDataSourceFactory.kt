package com.sofclient.tags.datasoutce

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.data.tags.Tag
import com.example.domain.tags.TagsUseCase

class TagsDataSourceFactory(val tagsInteractor: TagsUseCase) : DataSource.Factory<Long, Tag>() {
    private val tagsDataSourceLiveData = MutableLiveData<TagsDataSource>()

    override fun create(): DataSource<Long, Tag> {
        val tagsDataSource = TagsDataSource(tagsInteractor)
        tagsDataSourceLiveData.postValue(tagsDataSource)
        return tagsDataSource
    }
}