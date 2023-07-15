package com.example.disruptiveguestbook

import org.springframework.stereotype.Component

@Component
class HostBackgroundColorResolver(
    private val environmentProperties: EnvironmentProperties,
) {
    fun resolveColor() = when(environmentProperties.hostName) {
            "gerry-1" -> "blue"
            "gerry-2" -> "red"
            "gerry-3" -> "green"
            else -> "#1E90FF"
    }
}