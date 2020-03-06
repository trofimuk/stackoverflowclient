package com.example.data.tags

import com.example.data.utils.HttpClientUtils
import io.reactivex.Observable

class TagsGatewayImpl(
    private val httpClientUtils: HttpClientUtils
) : TagsGateway{

    override fun getTags(): Observable<TagsResponse> {
       return httpClientUtils.instance.getTags()
    }
}