package hello.my_projectV1.student.controller;

import hello.my_projectV1.student.repository.StudentSearchCond;
import hello.my_projectV1.student.repository.StudentUpdateDto;
import hello.my_projectV1.student.service.StudentService;
import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/{studentId}")
    public String student(@PathVariable Long studentId, Model model) {
        StudentVo student = studentService.findById(studentId).get();
        model.addAttribute("student", student);
        return "student";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute StudentVo studentVo, RedirectAttributes redirectAttributes) {
        StudentVo savedStudent = studentService.save(studentVo);
        redirectAttributes.addAttribute("studentId", savedStudent.getStudentId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/students/{studentId}";
    }

    @GetMapping("/{studentId}/edit")
    public String editForm(@PathVariable Long studentId, Model model) {
        StudentVo student = studentService.findById(studentId).get();
        model.addAttribute("student", student);
        return "editForm";
    }

    @PostMapping("/{studentId}/edit")
    public String edit(@PathVariable Long studentId, @ModelAttribute StudentUpdateDto updateDto) {
        studentService.update(studentId, updateDto);
        return "redirect:/students/{studentId}";
    }
}
