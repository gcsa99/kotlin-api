package br.com.raulens.forum.mapper

import br.com.raulens.forum.dto.CreateTopicForm
import br.com.raulens.forum.model.Topic
import br.com.raulens.forum.service.CourseService
import br.com.raulens.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<CreateTopicForm, Topic> {
    override fun map(t: CreateTopicForm): Topic =
        Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId),
            author = userService.findById(t.authorId),
        )
}
