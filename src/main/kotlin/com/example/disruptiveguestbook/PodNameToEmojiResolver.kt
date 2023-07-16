package com.example.disruptiveguestbook

import org.springframework.stereotype.Component
import kotlin.math.abs

@Component
class PodNameToEmojiResolver {

    val emojiMap = listOf("🙈","😜","😱","🎅","🖖","✊🏿","💣","👑","💎","🦊","🐧","🦋","🍒","🍣","🍺","🛵","⛵","🌈","💡","🔭")
    fun resolveToWithEmoji(input : String) : String{
        try {
            val countOfEmojis =  emojiMap.size
            val emojiIndex = abs(input.hashCode()) % countOfEmojis
            val podNameEnding = input.takeLast(5)
            return "$podNameEnding ${emojiMap[emojiIndex]}"
        }catch (e: RuntimeException) {
            return "💩"
        }

    }
}