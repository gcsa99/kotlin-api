package br.com.raulens.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateTopicForm(
    @field:NotEmpty(message = "Titulo não pode ser vazio")
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val title: String,
    @field:NotEmpty(message = "Mensagem não pode ser vazia")
    val message: String,
    @field:NotNull
    val courseId: Long,
    @field:NotNull
    val authorId: Long,
)
