package com.example.disruptiveguestbook

import org.springframework.stereotype.Component
@Component
class PodNameToEmojiResolver {

    val emojiMap = listOf("🙈","😜","😱","🎅","🖖","✊🏿","💣","👑","💎","🦊","🐧","🦋","🍒","🍣","🍺","🛵","⛵","🌈","💡","🔭")
    fun resolveToEmoji(input : String) : String{
        val countOfEmojis =  emojiMap.size
        val emojiIndex = input.hashCode() % countOfEmojis
        return emojiMap[emojiIndex]
    }
}