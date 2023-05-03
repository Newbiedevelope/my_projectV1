package hello.my_projectV1.student.vo;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class StudentVo {

    public static final StudentVo student = new StudentVo();

    private long studentId;

    private String studentName;

    private int studentAge;

    public StudentVo() {
    }

    public StudentVo(long studentId, String studentName, int studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
}
