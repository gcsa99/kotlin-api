package br.com.raulens.forum.repository

import br.com.raulens.forum.dto.TopicByCategoryReportDto
import br.com.raulens.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long> {
    fun findByCourseName(
        courseName: String,
        pagination: Pageable,
    ): Page<Topic>

    @Query(
        "SELECT new br.com.raulens.forum.dto.TopicByCategoryReportDto(course.category, count(t)) FROM Topic t JOIN t.course GROUP BY course.category",
    )
    fun report(): List<TopicByCategoryReportDto>
}
