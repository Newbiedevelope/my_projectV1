package hello.my_projectV1.subjectcode.repository;

import hello.my_projectV1.subjectcode.vo.SubjectCodeVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubjectCodeRepository {

    private final SqlSession session;

    /**
     * 과목 추가
     */
    public int createSubject(String subjectName) {
        return session.insert(
                "subjectCode.createSubject"
                , SubjectCodeVo.builder()
                        .subjectName(subjectName)
        );
    }

    /**
     * 과목 추가할 때 받은 과목명이 null 또는 빈값이라면 에러
     */
    public void subjectNameThrow(String subjectName) {
        if (subjectName == null || subjectName.isBlank()) {
            System.out.println("유효하지 않은 값입니다.");
            return;
        }

        subjectName = subjectName.trim();
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
