package com.example.disruptiveguestbook

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("environment")
class EnvironmentProperties {
    var podName: String = "unknown"
    var hostName: String = "unknown"
    var hostBackgroundColor: String = "#90EE90"
}