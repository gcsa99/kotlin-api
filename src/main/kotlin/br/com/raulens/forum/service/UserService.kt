package br.com.raulens.forum.service

import br.com.raulens.forum.model.User
import br.com.raulens.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
) {
    fun findById(id: Long): User = repository.findById(id).get()
}
