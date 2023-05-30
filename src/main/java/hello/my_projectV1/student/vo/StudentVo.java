package hello.my_projectV1.student.vo;

import hello.my_projectV1.subjectscore.vo.SubjectScoreVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


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

    private List<SubjectScoreVo> SubjectScoreList = new ArrayList<>();




}
