package hello.my_projectV1.subjectcode.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubjectCodeServiceTest {

    @Test
    void 응애() {

        String subjectName = "";
        test(subjectName);

        subjectName = " ";
        test(subjectName);

        subjectName = null;
        test(subjectName);

        subjectName = " 체육";
        test(subjectName);

        subjectName = "체육 ";
        test(subjectName);

    }

    public void test(String subjectName){

        if(subjectName == null || subjectName.isBlank()){
            System.out.println("에러 값");
            return;
        }

        subjectName = subjectName.trim();

    }
}