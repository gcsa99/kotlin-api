package br.com.raulens.forum.config

import br.com.raulens.forum.model.Course
import br.com.raulens.forum.model.User
import br.com.raulens.forum.repository.CourseRepository
import br.com.raulens.forum.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader {
    @Bean
    fun loadData(
        courseRepository: CourseRepository,
        userRepository: UserRepository,
    ) = CommandLineRunner {
        courseRepository.save(Course(name = "Kotlin", category = "Programacao"))
        courseRepository.save(Course(name = "Java", category = "Programacao"))
        userRepository.save(User(name = "Maria dos Anjos", email = "maria_dos_anjos@email.com"))
        userRepository.save(User(name = "Josevaldo da Silva", email = "josevaldo@email.com"))
    }
}
