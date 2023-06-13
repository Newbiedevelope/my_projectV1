package hello.my_projectV1.subjectcode.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCodeVo {

    private int subject_seq;
    private int subjectSeq;
    private String subjectName;

}
