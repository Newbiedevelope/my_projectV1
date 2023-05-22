package hello.my_projectV1.student.service;

import hello.my_projectV1.student.repository.StudentRepository;
import hello.my_projectV1.student.vo.StudentVo;
import hello.my_projectV1.subjectscore.repository.SubjectScoreRepository;
import hello.my_projectV1.subjectscore.service.SubjectScoreService;
import hello.my_projectV1.subjectscore.vo.SubjectScoreVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectScoreService subjectScoreService;

    /**
     * 생성
     */
    public int createStudent(StudentVo studentVo){

        // 학생 일련번호 받는다.
        int studentId = studentRepository.createStudent(studentVo);

        // 점수 등록한다. (학생 일련번호)
        subjectScoreService.whenCreateStudentAddSub(studentId);

        return studentId;

    }

    /**
     * 단건 조회
     */
    public StudentVo findById(long studentId){

        StudentVo student = studentRepository.findById(studentId);


        /**
         *
         */
        student.setSubjectScoreList(
                subjectScoreService.findScoreByStudentId((int) studentId)
        );


        return student;
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
     * 점수 수정
     */
    public int updateSubjectScore(SubjectScoreVo subjectScoreVo) {
        return subjectScoreService.updateSubjectScore(subjectScoreVo);
    }

    /**
     * 삭제
     */
    public int deleteById(long studentId) {
        return studentRepository.deleteById(studentId);
    }

}
