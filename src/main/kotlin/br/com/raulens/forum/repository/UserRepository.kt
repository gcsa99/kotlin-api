package br.com.raulens.forum.repository

import br.com.raulens.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
