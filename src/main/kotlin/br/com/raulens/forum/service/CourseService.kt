package br.com.raulens.forum.service

import br.com.raulens.forum.model.Course
import br.com.raulens.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository,
) {
    fun findById(id: Long): Course = repository.findById(id).get()
}
