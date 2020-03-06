package com.example.domain.tags

import io.reactivex.Observable

interface TagsUseCase {

    fun getTags() : Observable<TagsEntity>
}