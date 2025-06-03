package br.com.raulens.forum.repository

import br.com.raulens.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long>
