package hello.my_projectV1.subjectcode.repository;

import hello.my_projectV1.subjectcode.vo.SubjectCodeVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectCodeRepository {

    private final SqlSession session;

    /**
     * 과목 추가
     */
    public int createSubject(String subjectName) {

        SubjectCodeVo subject = SubjectCodeVo.builder()
                .subjectName(subjectName)
                .build();

         session.insert(
                "subjectCode.createSubject",
                 subject

        );

        return subject.getSubject_seq();
    }

    /**
     * 과목 코드&과목명 조회
     */
    public List<SubjectCodeVo> selectSubjectCode() {
        return session.selectList("subjectCode.selectSubjectCode");
    }

    /**
     * 과목 시퀀스로 단일 조회
     */
    public SubjectCodeVo selectSubjectCodeBySeq(int subjectSeq) {
        return session.selectOne("subjectCode.selectSubjectCodeBySeq",
                SubjectCodeVo.builder()
                        .subjectSeq(subjectSeq)
                        .build()
        );
    }

    /**
     * 과목명 변경
     */
    public int updateSubjectNameBySeq(int subjectSeq, String subjectName) {
        return session.update(
                "subjectCode.updateSubjectNameBySeq"
                , SubjectCodeVo.builder()
                        .subjectSeq(subjectSeq)
                        .subjectName(subjectName)
                        .build()
        );
    }

    /**
     * 과목 삭제
     */
    public int deleteSubjectBySeq(int subjectSeq) {
        return session.delete(
                "subjectCode.deleteSubjectBySeq"
                , SubjectCodeVo.builder()
                        .subjectSeq(subjectSeq)
                        .build()
        );
    }
}
