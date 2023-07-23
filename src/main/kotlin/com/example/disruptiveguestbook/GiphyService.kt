package com.example.disruptiveguestbook

import com.fasterxml.jackson.annotation.JsonProperty
import org.slf4j.LoggerFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.getForEntity

@Service
class GiphyService(
    templateBuilder: RestTemplateBuilder,
    private val giphyProperties: GiphyProperties
) {

    companion object {
        private val logger = LoggerFactory.getLogger(GiphyService::class.java)
    }

    val restTemplate = templateBuilder.rootUri(giphyProperties.url).build()

    fun findUrlForTag(tag: String): String? {
        try {
        val giphyResponse = restTemplate.getForEntity<GiphyResponse>(
            "/search?api_key={api-key}&q={tag}&limit={limit}&offset=0&rating=G&lang=en",
            giphyProperties.apikey, tag, 10
        )

        return giphyResponse.body?.data?.shuffled()?.firstOrNull()?.embedUrl

        } catch (e: RuntimeException){
            logger.error("Failed to load giphy url:",e)
            return null
        }
    }
}

data class GiphyResponse(val data: List<Giph>)

data class Giph(@JsonProperty("embed_url") val embedUrl: String)