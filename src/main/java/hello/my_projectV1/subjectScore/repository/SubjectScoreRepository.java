package hello.my_projectV1.subjectScore.repository;

import hello.my_projectV1.student.vo.StudentVo;
import hello.my_projectV1.subjectScore.vo.SubjectScoreVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubjectScoreRepository {

    // 아 개어렵다 뭐 어떻게 받지
    
    private final SqlSession session;

    public void whenCreateStudentAddSub(StudentVo studentVo) {
        session.insert("subjectScore.whenCreateStudentAddSub", studentVo);


    }
}
