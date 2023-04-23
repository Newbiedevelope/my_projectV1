package hello.my_projectV1.student.repository;

import hello.my_projectV1.student.vo.StudentVo;

import java.util.List;
import java.util.Optional;


public interface StudentRepository {

    StudentVo save(StudentVo studentVo);

    void update(Long studentId, StudentUpdateDto dtoParam);

    Optional<StudentVo> findById(Long studentId);

    List<StudentVo> findAll(StudentSearchCond cond);
}
