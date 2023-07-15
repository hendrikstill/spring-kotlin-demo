package com.example.disruptiveguestbook

data class MessagesDto(
    val messages: List<Message>,
    val podName: String = "unkown",
    val hostName: String = "unkown",
    val hostBackgroundColor: String = "#90EE90",
)
