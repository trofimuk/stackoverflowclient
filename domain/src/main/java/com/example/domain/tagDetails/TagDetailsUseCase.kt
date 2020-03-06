package com.example.domain.tagDetails

import io.reactivex.Observable

interface TagDetailsUseCase {

    fun getTagInfo(tag: String) : Observable<TagDetailsEntity>
}