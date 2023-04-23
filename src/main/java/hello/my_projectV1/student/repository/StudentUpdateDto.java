package hello.my_projectV1.student.repository;

import lombok.Data;

@Data
public class StudentUpdateDto {

    private String studentName;

    private int studentAge;

    public StudentUpdateDto() {
    }

    public StudentUpdateDto(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
}
