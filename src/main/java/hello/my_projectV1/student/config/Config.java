package hello.my_projectV1.student.config;

import hello.my_projectV1.student.repository.StudentQueryRepository;
import hello.my_projectV1.student.repository.StudentRepository;
import hello.my_projectV1.student.repository.StudentRepositoryImpl;
import hello.my_projectV1.student.repository.StudentRepositoryV2;
import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final EntityManager em;
    private final StudentRepositoryV2 studentRepositoryV2;

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl(studentRepositoryV2, studentQueryRepository());
    }

    @Bean
    public StudentQueryRepository studentQueryRepository() {
        return new StudentQueryRepository(em);
    }

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl(em);
    }
}

