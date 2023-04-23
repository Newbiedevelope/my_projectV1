package hello.my_projectV1.student.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.my_projectV1.student.vo.StudentVo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static hello.my_projectV1.vo.QStudent.student;

@Repository
public class StudentQueryRepository {

    private final JPAQueryFactory queryFactory;

    public StudentQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<StudentVo> findAll(StudentSearchCond cond) {
        return queryFactory
                .select(student)
                .from(student)
                .where(
                        likeStudentName(cond.getStudentName())
                        , age(cond.getStudentAge())
                )
                .fetch();
    }

    private BooleanExpression likeStudentName(String studentName) {
        if (StringUtils.hasText(studentName)) {
            return student.studentName.like("%" + studentName + "%");
        }

        return null;
    }

    private BooleanExpression age(Integer age) {
        if (age != null) {
            return student.studentAge.loe(age);
        }

        return null;
    }




}
