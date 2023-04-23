package hello.my_projectV1.student.service;

import hello.my_projectV1.student.repository.StudentQueryRepository;
import hello.my_projectV1.student.repository.StudentRepositoryV2;
import hello.my_projectV1.student.repository.StudentSearchCond;
import hello.my_projectV1.student.repository.StudentUpdateDto;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryV2 studentRepositoryV2;
    private final StudentQueryRepository studentQueryRepository;

    @Override
    public StudentVo save(StudentVo studentVo) {
        return studentRepositoryV2.save(studentVo);
    }

    @Override
    public void update(Long studentId, StudentUpdateDto updateDto) {
        StudentVo findStudent = findById(studentId).orElseThrow();
        findStudent.setStudentName(updateDto.getStudentName());
        findStudent.setStudentAge(updateDto.getStudentAge());    }

    @Override
    public Optional<StudentVo> findById(Long studentId) {
        return studentRepositoryV2.findById(studentId);
    }

    @Override
    public List<StudentVo> findStudents(StudentSearchCond cond) {
        return studentQueryRepository.findAll(cond);
    }
}
