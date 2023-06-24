package hello.my_projectV1.subjectscore.repository;

import hello.my_projectV1.subjectscore.vo.SubjectScoreVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectScoreRepository {

    private final SqlSession session;

    /**
     * 학생 객체 생성시 과목 생성
     */
    public void whenCreateStudentAddSub(int studentId, int subjectCode) {
        session.insert(
                "subjectScore.createStudentAddSub"
                , SubjectScoreVo.builder()
                        .studentId(studentId)
                        .subjectCode(subjectCode)
                        .build()
        );
    }

    /**
     * 학생 Id로 점수 찾기
     */
    public List<SubjectScoreVo> findScoreByStudentId(int studentId) {
        return session.selectList(
                "subjectScore.findScoreByStudentId"
                , SubjectScoreVo.builder()
                        .studentId(studentId)
                        .build());
    }

    /**
     * 점수 수정
     */
    public int updateSubjectScore(int studentId, int subjectCode, int subjectScore) {
        return session.update(
                "subjectScore.updateSubjectScore"
                , SubjectScoreVo.builder()
                    .studentId(studentId)
                    .subjectCode(subjectCode)
                    .subjectScore(subjectScore)
                    .build()
        );
    }

    /**
     * 과목 코드 테이블에서 과목 코드 삭제시, 스코어 테이블에서 참조하고 있는 해당 값의 모든 데이터 삭제
     */
    public int deleteSubjectScoreBySubjectCode(int subjectCode) {
        return session.delete("subjectScore.deleteSubjectScoreBySubjectCode",
                SubjectScoreVo.builder()
                        .subjectCode(subjectCode)
                        .build());
    }
}
