package hello.my_projectV1.student.controller;

import hello.my_projectV1.student.vo.StudentSearchCond;
import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
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
    @PostMapping("/{studentName}&{studentAge}")
    public int createStudent(@PathVariable StudentVo studentVo) {
        return studentService.createStudent(studentVo);
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
    @PostMapping
    public int updateStudent(long studentId, StudentVo studentVo) {
        return studentService.updateById(studentId, studentVo);
    }

    /**
     * 삭제
     */
    @GetMapping("/delete")
    public int deleteStudent(long studentId) {
        return studentService.deleteById(studentId);
    }
}
