package hello.my_projectV1.student.service;

import hello.my_projectV1.student.repository.StudentSearchCond;
import hello.my_projectV1.student.repository.StudentUpdateDto;
import hello.my_projectV1.student.vo.StudentVo;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    StudentVo save(StudentVo studentVo);

    void update(Long studentId, StudentUpdateDto updateDto);

    Optional<StudentVo> findById(Long studentId);

    List<StudentVo> findStudents(StudentSearchCond cond);
}
