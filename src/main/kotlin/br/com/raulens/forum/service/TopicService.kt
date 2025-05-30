package br.com.raulens.forum.service

import br.com.raulens.forum.model.Course
import br.com.raulens.forum.model.Topic
import br.com.raulens.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
) {
    init {
        var topic =
            Topic(
                id = 1,
                title = "title",
                message = "message",
                author =
                    User(
                        id = 1,
                        name = "raul",
                        email = "<EMAIL>",
                    ),
                course =
                    Course(
                        id = 1,
                        name = "Spring boot",
                        category = "Backend",
                    ),
            )
        var topic2 =
            Topic(
                id = 2,
                title = "title2",
                message = "message2",
                author =
                    User(
                        id = 1,
                        name = "raul2",
                        email = "<EMAIL2>",
                    ),
                course =
                    Course(
                        id = 2,
                        name = "Spring boot2",
                        category = "Backend",
                    ),
            )
        var topic3 =
            Topic(
                id = 3,
                title = "title3",
                message = "message3",
                author =
                    User(
                        id = 2,
                        name = "raul2",
                        email = "<EMAIL2>",
                    ),
                course =
                    Course(
                        id = 1,
                        name = "Spring boot",
                        category = "Backend",
                    ),
            )
        topics = listOf(topic, topic2, topic3)
    }

    fun list(): List<Topic> = topics

    fun getById(id: Long): Topic =
        topics
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .get()
}
