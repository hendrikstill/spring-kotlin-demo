package com.example.disruptiveguestbook

import org.springframework.stereotype.Component

@Component
class HostBackgroundColorResolver(
    private val environmentProperties: EnvironmentProperties,
) {
    fun resolveColor() = when(environmentProperties.hostName) {
            "gerry-1" -> "#5dade2" //Blue
            "gerry-2" -> "#ec7063" //Red
            "gerry-3" -> "#7dcea0" //Green
            else -> "#1E90FF"
    }
}