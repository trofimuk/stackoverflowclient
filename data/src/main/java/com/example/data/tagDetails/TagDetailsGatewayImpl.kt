package com.example.data.tagDetails

import com.example.data.utils.HttpClientUtils
import io.reactivex.Observable

class TagDetailsGatewayImpl(
    private val httpClientUtils: HttpClientUtils
) : TagDetailsGateway {

    override fun getTagInfo(tag: String): Observable<TagDetailsResponse> {
        return httpClientUtils.instance.getTagInfo(tag = tag)
    }
}