package hello.my_projectV1.student.vo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentVoTest {

    @Test
    void xx(){

        StudentVo vo = new StudentVo();
        test(vo);
        System.out.println(vo.getStudentName());

    }

    public void test(StudentVo vo){
        vo.setStudentName("hh");
    }
}