package hello.my_projectV1.student.controller;

import hello.my_projectV1.student.vo.StudentSearchCond;
import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public StudentVo findById(@PathVariable int studentId) {
        return studentService.findById(studentId);
    }

    @GetMapping
    public List<StudentVo> findStudents(@ModelAttribute("studentSearch") StudentSearchCond searchCond) {
        return studentService.findStudents(
                searchCond.toStudentVo()
        );
    }
}
