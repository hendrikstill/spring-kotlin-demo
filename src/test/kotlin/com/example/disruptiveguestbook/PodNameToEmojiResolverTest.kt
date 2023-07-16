package com.example.disruptiveguestbook

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PodNameToEmojiResolverTest{

    @Test
    fun `Assert EMOJI!!!!`(){
        val sut = PodNameToEmojiResolver()
        val result = sut.resolveToWithEmoji("disruptive-guestbook-5bbd9dc8d4-88sr2")
        Assertions.assertEquals("88sr2 \uD83E\uDD8A", result)

    }
}