package br.com.raulens.forum.controller

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.dto.DeleteTopicForm
import br.com.raulens.forum.dto.TopicView
import br.com.raulens.forum.dto.UpdateTopicForm
import br.com.raulens.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService,
) {
    @GetMapping
    fun get(): List<TopicView> = service.findAll()

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long,
    ): TopicView = service.findById(id)

    @PostMapping
    fun create(
        uriBuilder: UriComponentsBuilder,
        @RequestBody @Valid form: CreateTopicForm,
    ): ResponseEntity<TopicView> {
        val topicView = service.create(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(
        @RequestBody @Valid form: UpdateTopicForm,
    ): ResponseEntity<TopicView> {
        val topicView = service.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun delete(
        @RequestBody @Valid form: DeleteTopicForm,
    ) = service.delete(form)
}
