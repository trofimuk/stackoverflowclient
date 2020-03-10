package com.sofclient.tags.datasoutce

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.data.tags.Tag
import com.example.domain.tags.TagsUseCase

class TagsDataSourceFactory(val tagsInteractor: TagsUseCase) : DataSource.Factory<Long, Tag>() {
    private val usersDataSourceLiveData = MutableLiveData<TagsDataSource>()

    override fun create(): DataSource<Long, Tag> {
        val userDataSource = TagsDataSource(tagsInteractor)
        usersDataSourceLiveData.postValue(userDataSource)
        return userDataSource
    }
}