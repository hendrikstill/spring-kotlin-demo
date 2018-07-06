package com.example.disruptiveguestbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DisruptiveGuestbookApplication

fun main(args: Array<String>) {
    runApplication<DisruptiveGuestbookApplication>(*args)
}
