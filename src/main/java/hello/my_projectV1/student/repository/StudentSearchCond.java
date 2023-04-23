package hello.my_projectV1.student.repository;

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
}
