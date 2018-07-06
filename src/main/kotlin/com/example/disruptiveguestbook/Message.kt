package com.example.disruptiveguestbook

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.UUID

@Document
data class Message(
    @Id
    val id: UUID = UUID.randomUUID(),
    val createdAt: Instant = Instant.now(),
    val fromUser: String? = null,
    val text: String,
    val giphyLink: String? = null
)