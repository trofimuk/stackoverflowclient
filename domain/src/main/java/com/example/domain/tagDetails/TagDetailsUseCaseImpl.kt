package com.example.domain.tagDetails

import com.example.data.tagDetails.TagDetailsGateway
import com.example.data.tagDetails.TagDetailsResponse
import io.reactivex.Observable
import io.reactivex.functions.Function

class TagDetailsUseCaseImpl(
    private val tagDetailsGateway : TagDetailsGateway)
    : TagDetailsUseCase{

    override fun getTagInfo(tag: String): Observable<TagDetailsEntity> {
        return tagDetailsGateway.getTagInfo(tag = tag).map(TagDetailsDataMapper())
    }

    private inner class TagDetailsDataMapper : Function<TagDetailsResponse, TagDetailsEntity> {

        override fun apply(response: TagDetailsResponse): TagDetailsEntity {
            return TagDetailsEntity(response.items)
        }
    }


}