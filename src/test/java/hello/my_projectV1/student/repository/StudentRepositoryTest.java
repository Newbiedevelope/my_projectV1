package hello.my_projectV1.student.repository;

import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void 생성() {
        StudentVo studentVo = StudentVo.builder().build();
        studentRepository.createStudent(studentVo);
        log.info("studentCreate", studentRepository.findStudents(studentVo));
    }

    @Test
    void 단건조회() {
        Optional<StudentVo> op = Optional.ofNullable(studentRepository.findById(1));

        if(!op.isPresent()){
            System.out.println("X");
        }else{
            System.out.println(op.get().getStudentName());
            System.out.println(op.get().getStudentAge());
            System.out.println(op.get().getStudentId());
        }

    }

    @Test
    void 검색리스트조회() {
        StudentVo vo = StudentVo.builder().build();
        studentRepository.findStudents(vo);
    }

    @Test
    void 수정() {
        StudentVo studentVo = StudentVo.builder().build();
        StudentVo studentVo2 = StudentVo.builder().build();
        studentRepository.updateById(studentVo.getStudentId(), studentVo2);
    }

    @Test
    void 삭제() {
        studentRepository.deleteById(3);
    }

}