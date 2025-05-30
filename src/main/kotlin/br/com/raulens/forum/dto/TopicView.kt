package br.com.raulens.forum.dto

import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: String,
    val createdAt: LocalDateTime,
)
