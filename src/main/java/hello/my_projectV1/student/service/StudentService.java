package hello.my_projectV1.student.service;

import hello.my_projectV1.student.repository.StudentRepository;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * 단건 조회
     */
    public StudentVo findById(int studentId){
        return studentRepository.findById(studentId);
    }

    /**
     * 검색 리스트 조회
     */
    public List<StudentVo> findStudents(StudentVo studentVo){
        return studentRepository.findStudents(studentVo);
    }

    /**
     * 저장한다.
     */
    public StudentVo save(StudentVo studentVo){
        return null;
    }

    /**
     * 수정.
     */
    public void update(int studentId, StudentVo studentVo){
    }

}
