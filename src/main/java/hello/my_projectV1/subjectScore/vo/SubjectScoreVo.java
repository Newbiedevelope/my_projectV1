package hello.my_projectV1.subjectScore.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubjectScoreVo {

    private int student_id;
    private int subjectScore;
    private String subjectName;
    private long subjectScoreId;

}
