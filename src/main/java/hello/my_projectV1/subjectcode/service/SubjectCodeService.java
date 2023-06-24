package hello.my_projectV1.subjectcode.service;

import hello.my_projectV1.subjectcode.repository.SubjectCodeRepository;
import hello.my_projectV1.subjectcode.vo.SubjectCodeVo;
import hello.my_projectV1.subjectscore.repository.SubjectScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectCodeService {

    private final SubjectCodeRepository subjectCodeRepository;
    private final SubjectScoreRepository subjectScoreRepository;

    /**
     * 과목 생성
     */
    public int createSubject(String subjectName) {

        if (subjectName == null || subjectName.isBlank()) {
            System.out.println("입력값에 오류가 있습니다.");
            return -1;
        }

        subjectName = subjectName.trim();

        return subjectCodeRepository.createSubject(subjectName);
    }

    /**
     * 과목 코드&과목명 조회
     */
    public List<SubjectCodeVo> selectSubjectCode() {
        return subjectCodeRepository.selectSubjectCode();
    }

    /**
     * 과목명 변경
     */
    public SubjectCodeVo updateSubjectNameBySeq(int subjectSeq, String subjectName) {
        subjectCodeRepository.updateSubjectNameBySeq(subjectSeq, subjectName);

        return subjectCodeRepository.selectSubjectCodeBySeq(subjectSeq);
    }

    /**
     * 과목 삭제
     */
    public int deleteSubjectBySeq(int subjectSeq) {
        /** 과목 삭제 **/
        subjectCodeRepository.deleteSubjectBySeq(subjectSeq);

        /** subjectSeq 를 참조하고 있는 학생 점수들 모두 삭제 **/
        return subjectScoreRepository.deleteSubjectScoreBySubjectCode(subjectSeq);
    }
}
