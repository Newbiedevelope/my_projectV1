package hello.my_projectV1.student.vo;

import lombok.Data;

@Data
public class StudentSearchCond {

    private String studentName;

    private int studentAge;

    public StudentSearchCond() {
    }

    public StudentSearchCond(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public StudentVo toStudentVo(){
        return StudentVo.builder()
                .studentAge(studentAge)
                .studentName(studentName)
                .build();
    }
}
