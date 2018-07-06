package com.example.disruptiveguestbook

data class CreateMessageDto(
    val fromUser: String?,
    val text: String
)