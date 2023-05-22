package hello.my_projectV1.subjectscore.repository;

import hello.my_projectV1.student.vo.StudentVo;
import hello.my_projectV1.subjectscore.vo.SubjectScoreVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectScoreRepository {

    // 아 개어렵다 뭐 어떻게 받지

    private final SqlSession session;

    public void whenCreateStudentAddSub(int studentId, String subjectName) {
        session.insert(
                "subjectScore.createStudentAddSub"
                , SubjectScoreVo.builder()
                        .studentId(studentId)
                        .subjectName(subjectName)
                        .build()
        );
    }

    public List<SubjectScoreVo> findScoreByStudentId(int studentId) {
        return session.selectList("subjectScore.findScoreByStudentId"
                , SubjectScoreVo.builder()
                        .studentId(studentId)
                        .build());
    }

    public int updateSubjectScore(SubjectScoreVo subjectScoreVo) {
        return session.update("subjectScore.updateSubjectScore", subjectScoreVo);
    }


}
