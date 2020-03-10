package com.example.data.utils


import com.example.data.questions.QuestionsResponse
import com.example.data.tagDetails.TagDetailsResponse
import com.example.data.tags.TagsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Provides retrofit requests service
 *
 * @author Artyom Trofimuk
 */

interface ServiceAPI {

    /**
     * Returns tags
     */
    @GET("/tags?order=desc&sort=activity&site=stackoverflow")
    fun getTags(): Observable<TagsResponse>

    /**
     * Returns tag details
     */
    @GET("tags/{tag}/wikis?site=stackoverflow")
    fun getTagInfo(@Path("tag") tag: String): Observable<TagDetailsResponse>

    /**
     * Returns questions
     */
    @GET("/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(@Query("tagged") tagName : String): Observable<QuestionsResponse>

}