package br.com.raulens.forum.service

import br.com.raulens.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    var users: List<User>,
) {
    init {
        val user = User(id = 1, name = "Typescripto de Spring React", email = "java@rust.go")
        users = listOf(user)
    }

    fun findById(id: Long): User =
        users
            .stream()
            .filter({ c -> c.id == id })
            .findFirst()
            .get()
}
