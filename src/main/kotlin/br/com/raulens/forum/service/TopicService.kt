package br.com.raulens.forum.service

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.dto.DeleteTopicForm
import br.com.raulens.forum.dto.TopicView
import br.com.raulens.forum.dto.UpdateTopicForm
import br.com.raulens.forum.exception.NotFoundException
import br.com.raulens.forum.mapper.TopicFormMapper
import br.com.raulens.forum.mapper.TopicViewMapper
import br.com.raulens.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found",
) {
    fun findAll(): List<TopicView> =
        topics
            .stream()
            .map { t ->
                topicViewMapper.map(t)
            }.toList()

    fun findById(id: Long): TopicView {
        val topic =
            topics
                .stream()
                .filter { t -> t.id == id }
                .findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }

        return topicViewMapper.map(topic)
    }

    fun create(form: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics =
            topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic =
            topics
                .stream()
                .filter { t -> t.id == form.id }
                .findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }

        val updatedTopic =
            Topic(
                id = form.id,
                title = form.title,
                message = form.message,
                status = topic.status,
                author = topic.author,
                course = topic.course,
                createdAt = topic.createdAt,
            )
        topics =
            topics.minus(topic).plus(
                updatedTopic,
            )
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(form: DeleteTopicForm) {
        val topic =
            topics
                .stream()
                .filter { t -> t.id == form.id }
                .findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        topics =
            topics.minus(topic)
    }
}
