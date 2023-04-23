package hello.my_projectV1.student.controller;

import hello.my_projectV1.student.repository.StudentSearchCond;
import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String students(@ModelAttribute("studentSearch") StudentSearchCond searchCond, Model model) {
        List<StudentVo> students = studentService.findStudents(searchCond);
        model.addAttribute("students", students);
        return "students";
    }
}
