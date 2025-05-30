package br.com.raulens.forum.dto

data class CreateTopicDto(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long,
)
