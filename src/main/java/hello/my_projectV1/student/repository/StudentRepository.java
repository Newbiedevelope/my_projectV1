package hello.my_projectV1.student.repository;

import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepository {


    private final SqlSession session;

    /**
     * 단건 조회
     */
    public StudentVo findById(int studentId){

        return session.selectOne(
                "student.findById"
                , StudentVo.builder().studentId(studentId).build()
        );
    }

    /**
     * 검색 리스트 조회
     */
    public List<StudentVo> findStudents(StudentVo studentVo) {
        return session.selectList("student.findStudents", studentVo);

    }


}
