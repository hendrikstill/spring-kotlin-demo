package com.example.disruptiveguestbook

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface MessageRepository : MongoRepository<Message,UUID>{
    fun findByFromUser(user: String):List<Message>
}