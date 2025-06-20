package br.com.raulens.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "answers")
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic,
    val isSolution: Boolean = false,
)
