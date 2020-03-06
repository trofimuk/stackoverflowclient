package com.example.domain.tags

import com.example.data.tags.TagsGateway
import com.example.data.tags.TagsResponse
import io.reactivex.Observable
import io.reactivex.functions.Function

class TagsUseCaseImpl(val tagsGateway: TagsGateway) : TagsUseCase {

    override fun getTags(): Observable<TagsEntity> {
        return tagsGateway.getTags().map(TagsDataMapper())
    }

    private inner class TagsDataMapper : Function<TagsResponse, TagsEntity> {

        override fun apply(response: TagsResponse): TagsEntity {
            return TagsEntity(response.items)
        }
    }
}