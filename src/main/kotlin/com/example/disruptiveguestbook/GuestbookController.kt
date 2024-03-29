package com.example.disruptiveguestbook

import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GuestbookController(
    private val messageRepository: MessageRepository,
    private val giphyService: GiphyService,
    private val environmentProperties: EnvironmentProperties,
    private val hostBackgroundColorResolver: HostBackgroundColorResolver,
    private val emojiResolver: PodNameToEmojiResolver
) {

    companion object {
        private val log = LoggerFactory.getLogger(GuestbookController::class.java)
    }

    @GetMapping("/messages")
    fun getMessages(@RequestParam user: String?): MessagesDto {
        return when (user) {
            null -> MessagesDto(
                messages = messageRepository.findAll().sortedByDescending{ message -> message.createdAt }.take(20),
                podName = emojiResolver.resolveToWithEmoji(environmentProperties.podName),
                hostName = environmentProperties.hostName,
                hostBackgroundColor = hostBackgroundColorResolver.resolveColor()
            )
            else -> MessagesDto(messages = messageRepository.findByFromUser(user))
        }
    }

    @PostMapping("/messages")
    private fun addMessage(@RequestBody message: CreateMessageDto): ResponseEntity<CreateMessageDto> {
        val hashtag = extractHashtag(message.text)
        val giphyLink= hashtag?.let { giphyService.findUrlForTag(it) }

        messageRepository.save(Message(fromUser = message.fromUser, text = message.text, giphyLink = giphyLink))
        log.info("Message create {}", message)

        if(message.fromUser.equals("hendrik",true) && message.text.contains("delete")){
            messageRepository.deleteAll()
            log.info("Hendrik deleted all Messages!")
        }
        return ResponseEntity(message, HttpStatus.CREATED)
    }

    private fun extractHashtag(text: String): String? {
        val hashtag = text.substringAfter('#',"").substringBefore(" ")

        return when (hashtag.isEmpty()) {
            true -> null
            false -> hashtag
        }
    }

}