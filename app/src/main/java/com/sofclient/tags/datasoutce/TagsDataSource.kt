package com.sofclient.tags.datasoutce

import androidx.paging.ItemKeyedDataSource
import com.example.data.tags.Tag
import com.example.data.tags.TagsResponse
import com.example.domain.tags.TagsEntity
import com.example.domain.tags.TagsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class TagsDataSource(val tagsInteractor: TagsUseCase) : ItemKeyedDataSource<Long, Tag>() {

    companion object {
        val allCompositeDisposable: MutableList<Disposable> = arrayListOf()
    }

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Tag>) {
        val disposable = tagsInteractor.getTags()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { tagEntity ->
                callback.onResult(transform(tagEntity))
            }
        allCompositeDisposable.add(disposable)
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Tag>) {
        val disposable = tagsInteractor.getTags()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { tagEntity ->
                callback.onResult(transform(tagEntity))
            }
        allCompositeDisposable.add(disposable)
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Tag>) {
        // ignored, since we only ever append to our initial load
    }

    override fun getKey(item: Tag): Long = item.id

    private fun transform(tagEntity: TagsEntity): MutableList<Tag>{
        val userList = ArrayList<Tag>()
        tagEntity.items.forEach{
            userList.add(Tag(it.id, it.name, it.count))
        }
        return userList
    }
}