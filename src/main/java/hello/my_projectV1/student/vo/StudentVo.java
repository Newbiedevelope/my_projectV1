package hello.my_projectV1.student.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentVo {

//    public static final StudentVo student = new StudentVo();

    private int student_id;
    private long studentId;
    private String studentName;
    private int studentAge;

}
