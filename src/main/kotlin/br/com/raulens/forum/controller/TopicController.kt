package br.com.raulens.forum.controller

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.dto.DeleteTopicForm
import br.com.raulens.forum.dto.TopicView
import br.com.raulens.forum.dto.UpdateTopicForm
import br.com.raulens.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService,
) {
    @GetMapping
    @Cacheable("topics")
    fun get(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC) pagination: Pageable,
    ): Page<TopicView> = service.findAll(courseName, pagination)

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long,
    ): TopicView = service.findById(id)

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun create(
        uriBuilder: UriComponentsBuilder,
        @RequestBody @Valid form: CreateTopicForm,
    ): ResponseEntity<TopicView> {
        val topicView = service.create(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(
        @RequestBody @Valid form: UpdateTopicForm,
    ): ResponseEntity<TopicView> {
        val topicView = service.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun delete(
        @RequestBody @Valid form: DeleteTopicForm,
    ) = service.delete(form)
}
