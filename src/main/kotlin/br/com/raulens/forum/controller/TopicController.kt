package br.com.raulens.forum.controller

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.dto.TopicView
import br.com.raulens.forum.service.TopicService
import org.springframework.web.bind.annotation.*

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
        @RequestBody dto: CreateTopicForm,
    ) = service.create(dto)
}
