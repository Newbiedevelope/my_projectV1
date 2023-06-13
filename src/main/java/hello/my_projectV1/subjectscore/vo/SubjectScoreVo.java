package hello.my_projectV1.subjectscore.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubjectScoreVo {

    private int sub_score_id;
    private int studentId;
    private int subjectScore;
    private int subjectCode;
    private long subjectScoreId;
    private String subjectName;

}
