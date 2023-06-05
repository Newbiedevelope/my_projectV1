package hello.my_projectV1.subjectcode.service;

import hello.my_projectV1.subjectcode.repository.SubjectCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectCodeService {

    private final SubjectCodeRepository subjectCodeRepository;

    /**
     * 과목 생성
     */
    public int createSubject(String subjectName) {
        return subjectCodeRepository.createSubject(subjectName);
    }

    /**
     * 과목명 변경
     */
    public int updateSubjectNameBySeq(int subjectSeq, String subjectName) {
        return subjectCodeRepository.updateSubjectNameBySeq(subjectSeq, subjectName);
    }

    /**
     * 과목 삭제
     */
    public int deleteSubjectBySeq(int subjectSeq) {
        return subjectCodeRepository.deleteSubjectBySeq(subjectSeq);
    }
}
