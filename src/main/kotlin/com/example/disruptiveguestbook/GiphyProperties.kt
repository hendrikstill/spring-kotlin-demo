package com.example.disruptiveguestbook

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("giphy")
class GiphyProperties {
    lateinit var apikey: String
    var url: String = "https://api.giphy.com/v1/gifs"
}