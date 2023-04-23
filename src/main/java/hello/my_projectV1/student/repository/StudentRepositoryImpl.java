package hello.my_projectV1.student.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.my_projectV1.student.vo.StudentVo;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static hello.my_projectV1.vo.QStudent.student;

public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public StudentVo save(StudentVo studentVo) {
        em.persist(studentVo);
        return studentVo;
    }

    @Override
    public void update(Long studentId, StudentUpdateDto dtoParam) {
        StudentVo findStudent = findById(studentId).orElseThrow();
        findStudent.setStudentName(dtoParam.getStudentName());
        findStudent.setStudentAge(dtoParam.getStudentAge());
    }

    @Override
    public Optional<StudentVo> findById(Long studentId) {
        StudentVo student = em.find(StudentVo.class, studentId);
        return Optional.ofNullable(student);
    }

    @Override
    public List<StudentVo> findAll(StudentSearchCond cond) {
        return null;
    }

}
