package hello.my_projectV1.student.repository;

import hello.my_projectV1.student.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {


    private final SqlSession session;

    /**
     * 객체(학생) 생성
     */
    public int createStudent(StudentVo studentVo) {
        int insert = session.insert("student.createStudent", studentVo);

        return studentVo.getStudent_id();
    }

    /**
     * 단건 조회
     */
    public StudentVo findById(long studentId){
        return session.selectOne("student.findById", StudentVo.builder().studentId(studentId).build());
    }

    /**
     * 검색 리스트 조회
     */
    public List<StudentVo> findStudents(StudentVo studentVo) {
        return session.selectList("student.findStudents", studentVo);
    }

    /**
     * 수정
     */
    public int updateById(long studentId, StudentVo studentVo) {
        return session.update("student.updateById", studentVo);
    }

    /**
     * 삭제
     */
    public int deleteById(long studentId) {
        return session.delete("student.deleteById", StudentVo.builder().studentId(studentId).build());
    }


}
