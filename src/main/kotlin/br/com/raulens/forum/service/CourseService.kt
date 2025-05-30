package br.com.raulens.forum.service

import br.com.raulens.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    var courses: List<Course>,
) {
    init {
        val course = Course(id = 1, name = "Spring Boot", category = "Backend")
        courses = listOf(course)
    }

    fun findById(id: Long): Course =
        courses
            .stream()
            .filter({ c -> c.id == id })
            .findFirst()
            .get()
}
