package hello.my_projectV1.student.controller;

import hello.my_projectV1.student.vo.StudentSearchCond;
import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    /**
     * 생성
     */
//    @PostMapping("/{studentName}&{studentAge}")
    @PostMapping
    public int createStudent(
            @Param("studentName") String studentName
            , @Param("studentAge") int studentAge
    ) {

        System.out.println(studentName);
        System.out.println(studentAge);

        return studentService.createStudent(
                StudentVo.builder()
                        .studentName(studentName)
                        .studentAge(studentAge)
                        .build()
        );
    }

    /**
     * 단건 조회
     */
    @GetMapping("/{studentId}")
    public StudentVo findById(@PathVariable long studentId) {
        return studentService.findById(studentId);
    }

    /**
     * 검색 리스트 조회
     */
    @GetMapping
    public List<StudentVo> findStudents(@ModelAttribute("studentSearch") StudentSearchCond searchCond) {
        return studentService.findStudents(
                searchCond.toStudentVo()
        );
    }

    /**
     * 수정
     */
    @PatchMapping
    public int updateStudent(long studentId, StudentVo studentVo) {
        return studentService.updateById(studentId, studentVo);
    }

    @PatchMapping("/subject")
    public int updateSubjectScore(int studentId, int subjectCode, int subjectScore) {
        return studentService.updateSubjectScore(studentId, subjectCode, subjectScore);
    }

    /**
     * 삭제
     */
    @GetMapping("/delete")
    public int deleteStudent(long studentId) {
        return studentService.deleteById(studentId);
    }
}
