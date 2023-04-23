package hello.my_projectV1.student.repository;

import hello.my_projectV1.student.vo.StudentVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryV2 extends JpaRepository<StudentVo, Long> {
}
