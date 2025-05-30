package br.com.raulens.forum.controller

import br.com.raulens.forum.model.Topic
import br.com.raulens.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService,
) {
    @GetMapping
    fun get(): List<Topic> = service.list()

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long,
    ): Topic = service.getById(id)
}
