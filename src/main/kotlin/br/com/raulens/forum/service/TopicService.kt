package br.com.raulens.forum.service

import br.com.raulens.forum.dto.*
import br.com.raulens.forum.exception.NotFoundException
import br.com.raulens.forum.mapper.TopicFormMapper
import br.com.raulens.forum.mapper.TopicViewMapper
import br.com.raulens.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found",
) {
    fun findAll(
        courseName: String?,
        pagination: Pageable,
    ): Page<TopicView> {
        val topic =
            if (courseName != null) {
                repository.findByCourseName(courseName, pagination)
            } else {
                repository.findAll(pagination)
            }
        return topic.map { t -> topicViewMapper.map(t) }
    }

    fun findById(id: Long): TopicView {
        val topic =
            repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }

        return topicViewMapper.map(topic)
    }

    fun create(form: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic =
            repository
                .findById(form.id)
                .orElseThrow { NotFoundException(notFoundMessage) }
        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)
    }

    fun delete(form: DeleteTopicForm) {
        repository.deleteById(form.id)
    }

    fun report(): List<TopicByCategoryReportDto> = repository.report()
}
