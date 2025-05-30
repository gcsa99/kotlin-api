package br.com.raulens.forum.mapper

import br.com.raulens.forum.dto.TopicView
import br.com.raulens.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView =
        TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status.name,
            createdAt = t.createdAt,
        )
}
