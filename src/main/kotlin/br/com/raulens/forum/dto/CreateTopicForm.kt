package br.com.raulens.forum.dto

data class CreateTopicForm(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long,
)
