package com.example.data.tags

import io.reactivex.Observable

interface TagsGateway {

    fun getTags() : Observable<TagsResponse>
}