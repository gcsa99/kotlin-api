package br.com.raulens.forum.service

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.dto.DeleteTopicForm
import br.com.raulens.forum.dto.TopicView
import br.com.raulens.forum.dto.UpdateTopicForm
import br.com.raulens.forum.mapper.TopicFormMapper
import br.com.raulens.forum.mapper.TopicViewMapper
import br.com.raulens.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
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
                .get()

        return topicViewMapper.map(topic)
    }

    fun create(form: CreateTopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics =
            topics.plus(topic)
    }

    fun update(form: UpdateTopicForm) {
        val topic =
            topics
                .stream()
                .filter { t -> t.id == form.id }
                .findFirst()
                .get()
        topics =
            topics.minus(topic).plus(
                Topic(
                    id = form.id,
                    title = form.title,
                    message = form.message,
                    status = topic.status,
                    author = topic.author,
                    course = topic.course,
                    createdAt = topic.createdAt,
                ),
            )
    }

    fun delete(form: DeleteTopicForm) {
        val topic =
            topics
                .stream()
                .filter { t -> t.id == form.id }
                .findFirst()
                .get()
        topics =
            topics.minus(topic)
    }
}
