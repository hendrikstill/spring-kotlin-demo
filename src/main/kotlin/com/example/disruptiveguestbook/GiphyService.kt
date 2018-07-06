package com.example.disruptiveguestbook

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.getForEntity

@Service
class GiphyService(
    templateBuilder: RestTemplateBuilder,
    private val giphyProperties: GiphyProperties
) {

    val restTemplate = templateBuilder.rootUri(giphyProperties.url).build()

    fun findUrlForTag(tag: String): String? {

        val giphyResponse = restTemplate.getForEntity<GiphyResponse>(
            "/search?api_key={api-key}&q={tag}&limit={limit}&offset=0&rating=G&lang=en",
            giphyProperties.apikey, tag, 10
        )

        return giphyResponse.body?.data?.shuffled()?.firstOrNull()?.embedUrl
    }
}

data class GiphyResponse(val data: List<Giph>)

data class Giph(@JsonProperty("embed_url") val embedUrl: String)