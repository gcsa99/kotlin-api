package br.com.raulens.forum.repository

import br.com.raulens.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long>
