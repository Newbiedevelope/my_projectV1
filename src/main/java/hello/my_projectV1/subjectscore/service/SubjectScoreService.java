package hello.my_projectV1.subjectscore.service;

import hello.my_projectV1.subjectscore.repository.SubjectScoreRepository;
import hello.my_projectV1.subjectscore.vo.SubjectScoreVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectScoreService {

    private final SubjectScoreRepository repository;

    public void whenCreateStudentAddSub (int studentId){

        int[] subjectArr = new int[]{1, 2, 3, 4};

        for (int subjectCode : subjectArr) {
            repository.whenCreateStudentAddSub(
                    studentId
                    , subjectCode
            );
        }
    }

    /**
     * studentId 의 점수를 조회해서  List<SubjectScoreVO> 로 반환한다.
     */
    public List<SubjectScoreVo> findScoreByStudentId(int studentId) {
        return repository.findScoreByStudentId(studentId);
    }

    /**
     * @param studentId
     * @param subjectCode
     * @param subjectScore
     * @return
     */
    public int updateSubjectScore(int studentId, int subjectCode, int subjectScore) {
        return repository.updateSubjectScore(studentId, subjectCode, subjectScore);
    }
}
