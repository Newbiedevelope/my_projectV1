package hello.my_projectV1.student.service;

import hello.my_projectV1.student.repository.StudentRepository;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * 생성
     */
    public int createStudent(StudentVo studentVo){
        return studentRepository.createStudent(studentVo);
    }

    /**
     * 단건 조회
     */
    public StudentVo findById(long studentId){
        return studentRepository.findById(studentId);
    }

    /**
     * 검색 리스트 조회
     */
    public List<StudentVo> findStudents(StudentVo studentVo){
        return studentRepository.findStudents(studentVo);
    }

    /**
     * 수정
     */
    public int updateById(long studentId, StudentVo studentVo) {
        return studentRepository.updateById(studentId, studentVo);
    }

    /**
     * 삭제
     */
    public int deleteById(long studentId) {
        return studentRepository.deleteById(studentId);
    }

}
