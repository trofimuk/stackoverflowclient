package com.example.data.tagDetails

import io.reactivex.Observable

interface TagDetailsGateway {

    fun getTagInfo(tag: String) : Observable<TagDetailsResponse>
}