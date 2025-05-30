package br.com.raulens.forum.service

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.dto.TopicView
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
}
